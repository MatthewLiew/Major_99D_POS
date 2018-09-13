/*
**    Chromis POS  - The New Face of Open Source POS
**    Copyright (c)2015-2016
**    http://www.chromis.co.uk
**
**    This file is part of Chromis POS Version V0.60.2 beta
**
**    Chromis POS is free software: you can redistribute it and/or modify
**    it under the terms of the GNU General Public License as published by
**    the Free Software Foundation, either version 3 of the License, or
**    (at your option) any later version.
**
**    Chromis POS is distributed in the hope that it will be useful,
**    but WITHOUT ANY WARRANTY; without even the implied warranty of
**    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
**    GNU General Public License for more details.
**
**    You should have received a copy of the GNU General Public License
**    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>
**
**
*/
//   VogomoPOS - PointOfSale
//   Copyright (c) (c) 2015-2018  
//
//   This file is part of VogomoPOS
//
//   www.vogomo.com
//   
//   edited by: Matthew

package uk.chromis.pos.sales.restaurant;

import bsh.EvalError;
import bsh.Interpreter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uk.chromis.data.gui.JMessageDialog;
import uk.chromis.data.gui.ListKeyed;
import uk.chromis.data.gui.MessageInf;
import uk.chromis.data.loader.SentenceList;
import uk.chromis.pos.forms.AppLocal;
import uk.chromis.pos.forms.AppView;
import uk.chromis.pos.forms.DataLogicSystem;
import uk.chromis.pos.forms.JRootApp;
import uk.chromis.pos.printer.DeviceTicket;
import uk.chromis.pos.printer.TicketParser;
import uk.chromis.pos.printer.TicketPrinterException;
import uk.chromis.pos.sales.JPanelTicket;
import static uk.chromis.pos.sales.JPanelTicket.autoLogoffAfterKitchen;
import static uk.chromis.pos.sales.JPanelTicket.autoLogoffEnabled;
import static uk.chromis.pos.sales.JPanelTicket.autoLogoffToTables;
import uk.chromis.pos.sales.TaxesLogic;
import uk.chromis.pos.scripting.ScriptEngine;
import uk.chromis.pos.scripting.ScriptException;
import uk.chromis.pos.scripting.ScriptFactory;
import uk.chromis.pos.ticket.TicketInfo;
import uk.chromis.pos.ticket.TicketLineInfo;
import uk.chromis.pos.ticket.TicketType;

/**
 *
 *
 */
public class JTicketsBagRestaurant extends javax.swing.JPanel {

    private final AppView m_App;
    private final JTicketsBagRestaurantMap m_restaurant;
    private List<TicketLineInfo> m_aLines;
    private TicketLineInfo line;
    private TicketInfo ticket;
    private final Object ticketExt;
    private DataLogicSystem m_dlSystem = null;
    private final DeviceTicket m_TP;
    private final TicketParser m_TTP2;
    private final RestaurantDBUtils restDB;

    private final DataLogicSystem dlSystem = null;
    private TicketParser m_TTP;

    private SentenceList senttax;
    private ListKeyed taxcollection;
    private TaxesLogic taxeslogic;

    private Interpreter i;

    /**
     * Creates new form JTicketsBagRestaurantMap
     *
     * @param app
     * @param restaurant
     */
    public JTicketsBagRestaurant(AppView app, JTicketsBagRestaurantMap restaurant) {
        super();
        m_App = app;
        m_restaurant = restaurant;
        initComponents();
        ticketExt = null;

        restDB = new RestaurantDBUtils(m_App);

        m_dlSystem = (DataLogicSystem) m_App.getBean("uk.chromis.pos.forms.DataLogicSystem");
        m_TP = new DeviceTicket(app.getProperties());

        m_TTP2 = new TicketParser(m_App.getDeviceTicket(), m_dlSystem);
        m_KitchenPrint.setVisible(m_App.getAppUserView().getUser().hasPermission("sales.PrintKitchen"));
        m_KitchenPrint.setVisible(false);

    }
    
    // Edited By Matthew
    public void setTablesIcon(boolean hasOrderNotSend, String resource){
//        m_TablePlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/tables.png")));
        if(hasOrderNotSend){
            m_TablePlan.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
        } else {
            m_TablePlan.setIcon(new javax.swing.ImageIcon(getClass().getResource(resource)));
        }
    }

    /**
     *
     */
    public void activate() {

        // Authorization
        m_DelTicket.setEnabled(m_App.getAppUserView().getUser().hasPermission("uk.chromis.pos.sales.JPanelTicketEdits"));

    }

    /**
     *
     * @param resource
     */
    public void printTicket(String resource) {
        printTicket(resource, ticket, m_restaurant.getTable());
    }

    private void printTicket(String sresourcename, TicketInfo ticket, String table) {
        if (ticket != null) {
            try {
                ScriptEngine script = ScriptFactory.getScriptEngine(ScriptFactory.VELOCITY);
                script.put("ticket", ticket);
                script.put("place", m_restaurant.getTableName());
                m_TTP2.printTicket(script.eval(m_dlSystem.getResourceAsXML(sresourcename)).toString());
            } catch (ScriptException | TicketPrinterException e) {
                JMessageDialog.showMessage(this, new MessageInf(MessageInf.SGN_NOTICE, AppLocal.getIntString("message.cannotprint"), e));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_DelTicket = new javax.swing.JButton();
        m_MoveTable = new javax.swing.JButton();
        m_TablePlan = new javax.swing.JButton();
        m_KitchenPrint = new javax.swing.JButton();

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(250, 50));
        setPreferredSize(new java.awt.Dimension(250, 50));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        m_DelTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/sale_delete.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        m_DelTicket.setToolTipText(bundle.getString("tiptext.deletecurrentorder")); // NOI18N
        m_DelTicket.setFocusPainted(false);
        m_DelTicket.setFocusable(false);
        m_DelTicket.setMargin(new java.awt.Insets(0, 4, 0, 4));
        m_DelTicket.setMaximumSize(new java.awt.Dimension(50, 40));
        m_DelTicket.setMinimumSize(new java.awt.Dimension(50, 40));
        m_DelTicket.setPreferredSize(new java.awt.Dimension(52, 40));
        m_DelTicket.setRequestFocusEnabled(false);
        m_DelTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_DelTicketActionPerformed(evt);
            }
        });
        add(m_DelTicket);

        m_MoveTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/movetable.png"))); // NOI18N
        m_MoveTable.setToolTipText(bundle.getString("tiptext.movetable")); // NOI18N
        m_MoveTable.setFocusPainted(false);
        m_MoveTable.setFocusable(false);
        m_MoveTable.setMargin(new java.awt.Insets(0, 4, 0, 4));
        m_MoveTable.setMaximumSize(new java.awt.Dimension(50, 40));
        m_MoveTable.setMinimumSize(new java.awt.Dimension(50, 40));
        m_MoveTable.setPreferredSize(new java.awt.Dimension(52, 40));
        m_MoveTable.setRequestFocusEnabled(false);
        m_MoveTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_MoveTableActionPerformed(evt);
            }
        });
        add(m_MoveTable);

        m_TablePlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/tables.png"))); // NOI18N
        m_TablePlan.setToolTipText(bundle.getString("tiptext.gototableplan")); // NOI18N
        m_TablePlan.setFocusPainted(false);
        m_TablePlan.setFocusable(false);
        m_TablePlan.setMargin(new java.awt.Insets(0, 4, 0, 4));
        m_TablePlan.setMaximumSize(new java.awt.Dimension(50, 40));
        m_TablePlan.setMinimumSize(new java.awt.Dimension(50, 40));
        m_TablePlan.setPreferredSize(new java.awt.Dimension(52, 40));
        m_TablePlan.setRequestFocusEnabled(false);
        m_TablePlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_TablePlanActionPerformed(evt);
            }
        });
        add(m_TablePlan);

        m_KitchenPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/printer24.png"))); // NOI18N
        m_KitchenPrint.setToolTipText(bundle.getString("tiptext.sendtokitchen")); // NOI18N
        m_KitchenPrint.setMargin(new java.awt.Insets(0, 4, 0, 4));
        m_KitchenPrint.setMaximumSize(new java.awt.Dimension(50, 40));
        m_KitchenPrint.setMinimumSize(new java.awt.Dimension(50, 40));
        m_KitchenPrint.setPreferredSize(new java.awt.Dimension(52, 40));
        m_KitchenPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_KitchenPrintActionPerformed(evt);
            }
        });
        add(m_KitchenPrint);
    }// </editor-fold>//GEN-END:initComponents

    private void m_MoveTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_MoveTableActionPerformed
        restDB.clearCustomerNameInTableById(m_restaurant.getTable());
        restDB.clearWaiterNameInTableById(m_restaurant.getTable());
        restDB.clearTicketIdInTableById(m_restaurant.getTable());
        restDB.setTableMovedFlag(m_restaurant.getTable());
        restDB.clearTableLock(m_restaurant.getTable());
        m_restaurant.moveTicket();
    }//GEN-LAST:event_m_MoveTableActionPerformed

    @SuppressWarnings("empty-statement")
    private void m_DelTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_DelTicketActionPerformed
        int res = JOptionPane.showConfirmDialog(this, AppLocal.getIntString("message.wannadelete"), AppLocal.getIntString("title.editor"), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            restDB.clearCustomerNameInTableById(m_restaurant.getTable());
            restDB.clearWaiterNameInTableById(m_restaurant.getTable());
            restDB.clearTicketIdInTableById(m_restaurant.getTable());
            restDB.clearTableLock(m_restaurant.getTable());
            m_restaurant.deleteTicket();
        }

    }//GEN-LAST:event_m_DelTicketActionPerformed

    private void m_TablePlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_TablePlanActionPerformed
        restDB.clearTableLock(m_restaurant.getTable());
        m_restaurant.newTicket();
    }//GEN-LAST:event_m_TablePlanActionPerformed

    @SuppressWarnings("empty-statement")
    private void m_KitchenPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_KitchenPrintActionPerformed
// This replaces the code from the buttons script
        if (!ticket.getTicketType().equals(TicketType.REFUND)) {
            ticket = m_restaurant.getActiveTicket();
            String rScript = (m_dlSystem.getResourceAsText("script.SendOrder"));

            Interpreter i = new Interpreter();
            try {
                i.set("ticket", ticket);
                i.set("place", m_restaurant.getTableName());
                i.set("user", m_App.getAppUserView().getUser());
                i.set("sales", this);
                Object result = i.eval(rScript);
            } catch (EvalError ex) {
                Logger.getLogger(JPanelTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Autologoff after printing to kitchen                                
            if (autoLogoffEnabled && autoLogoffAfterKitchen) {
                // check how far to logoof to ie tables or application
                if (autoLogoffToTables) {
                    m_restaurant.newTicket();
                } else {
                    ((JRootApp) m_App).closeAppView();
                }
            }

    }//GEN-LAST:event_m_KitchenPrintActionPerformed
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton m_DelTicket;
    private javax.swing.JButton m_KitchenPrint;
    private javax.swing.JButton m_MoveTable;
    private javax.swing.JButton m_TablePlan;
    // End of variables declaration//GEN-END:variables

}
