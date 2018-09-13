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

package uk.chromis.pos.reports;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import uk.chromis.basic.BasicException;
import uk.chromis.data.loader.SerializerWrite;
import uk.chromis.data.loader.SerializerWriteComposed;
import uk.chromis.pos.forms.AppView;

/**
 *
 *   
 */
public class JParamsComposed extends javax.swing.JPanel implements ReportEditorCreator {
    

    private List<ReportEditorCreator> editors = new ArrayList<>();
    
    /** Creates new form JParamsComposed */
    public JParamsComposed() {
        initComponents();   
    }

    /**
     *
     * @param app
     */
    @Override
    public void init(AppView app) {
        for (ReportEditorCreator qbff : editors) {
            qbff.init(app);
        }
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
        for (ReportEditorCreator qbff : editors) {
            qbff.activate();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public SerializerWrite getSerializerWrite() {
        
        SerializerWriteComposed sw = new SerializerWriteComposed();
        
        for (ReportEditorCreator qbff : editors) {
            sw.add(qbff.getSerializerWrite());
        }        
    
        return sw;
    }

    /**
     *
     * @return
     */
    @Override
    public Component getComponent() {
        return this;
    }

    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {
        
        Object[] value = new Object[editors.size()];
        
        for(int i = 0; i < editors.size(); i++) {
            value[i] = editors.get(i).createValue();
        }        
        return value;
    }

    /**
     *
     * @param c
     */
    public void addEditor(ReportEditorCreator c) {
        editors.add(c);
        add(c.getComponent());
    }
    
    /**
     *
     * @return
     */
    public boolean isEmpty() {
        
        return editors.isEmpty();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
