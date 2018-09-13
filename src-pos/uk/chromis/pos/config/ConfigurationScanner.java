/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.chromis.pos.config;

/**
 *
 * @author Vogomo Pte Ltd
 */
public class ConfigurationScanner {

    /**
     * org.w3c.dom.Document document
     */
    org.w3c.dom.Document document;

    /**
     * Create new ConfigurationScanner with org.w3c.dom.Document.
     */
    public ConfigurationScanner(org.w3c.dom.Document document) {
        this.document = document;
    }

    /**
     * Scan through org.w3c.dom.Document document.
     */
    public void visitDocument() {
        org.w3c.dom.Element element = document.getDocumentElement();
        if ((element != null) && element.getTagName().equals("AnchorPane")) {
            visitElement_AnchorPane(element);
        }
        if ((element != null) && element.getTagName().equals("children")) {
            visitElement_children(element);
        }
        if ((element != null) && element.getTagName().equals("TabPane")) {
            visitElement_TabPane(element);
        }
        if ((element != null) && element.getTagName().equals("tabs")) {
            visitElement_tabs(element);
        }
        if ((element != null) && element.getTagName().equals("Tab")) {
            visitElement_Tab(element);
        }
        if ((element != null) && element.getTagName().equals("ButtonBar")) {
            visitElement_ButtonBar(element);
        }
        if ((element != null) && element.getTagName().equals("buttons")) {
            visitElement_buttons(element);
        }
        if ((element != null) && element.getTagName().equals("Button")) {
            visitElement_Button(element);
        }
    }

    /**
     * Scan through org.w3c.dom.Element named AnchorPane.
     */
    void visitElement_AnchorPane(org.w3c.dom.Element element) {
        // <AnchorPane>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("maxHeight")) {
                // <AnchorPane maxHeight="???">
                // attr.getValue();
            }
            if (attr.getName().equals("maxWidth")) {
                // <AnchorPane maxWidth="???">
                // attr.getValue();
            }
            if (attr.getName().equals("minHeight")) {
                // <AnchorPane minHeight="???">
                // attr.getValue();
            }
            if (attr.getName().equals("minWidth")) {
                // <AnchorPane minWidth="???">
                // attr.getValue();
            }
            if (attr.getName().equals("prefHeight")) {
                // <AnchorPane prefHeight="???">
                // attr.getValue();
            }
            if (attr.getName().equals("prefWidth")) {
                // <AnchorPane prefWidth="???">
                // attr.getValue();
            }
            if (attr.getName().equals("xmlns")) {
                // <AnchorPane xmlns="???">
                // attr.getValue();
            }
            if (attr.getName().equals("xmlns:fx")) {
                // <AnchorPane xmlns:fx="???">
                // attr.getValue();
            }
            if (attr.getName().equals("fx:id")) {
                // <AnchorPane fx:id="???">
                // attr.getValue();
            }
            if (attr.getName().equals("fx:controller")) {
                // <AnchorPane fx:controller="???">
                // attr.getValue();
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("children")) {
                        visitElement_children(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named children.
     */
    void visitElement_children(org.w3c.dom.Element element) {
        // <children>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("TabPane")) {
                        visitElement_TabPane(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("ButtonBar")) {
                        visitElement_ButtonBar(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named TabPane.
     */
    void visitElement_TabPane(org.w3c.dom.Element element) {
        // <TabPane>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("prefHeight")) {
                // <TabPane prefHeight="???">
                // attr.getValue();
            }
            if (attr.getName().equals("prefWidth")) {
                // <TabPane prefWidth="???">
                // attr.getValue();
            }
            if (attr.getName().equals("tabClosingPolicy")) {
                // <TabPane tabClosingPolicy="???">
                // attr.getValue();
            }
            if (attr.getName().equals("fx:id")) {
                // <TabPane fx:id="???">
                // attr.getValue();
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("tabs")) {
                        visitElement_tabs(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named tabs.
     */
    void visitElement_tabs(org.w3c.dom.Element element) {
        // <tabs>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("Tab")) {
                        visitElement_Tab(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Tab.
     */
    void visitElement_Tab(org.w3c.dom.Element element) {
        // <Tab>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("closable")) {
                // <Tab closable="???">
                // attr.getValue();
            }
            if (attr.getName().equals("style")) {
                // <Tab style="???">
                // attr.getValue();
            }
            if (attr.getName().equals("text")) {
                // <Tab text="???">
                // attr.getValue();
            }
            if (attr.getName().equals("fx:id")) {
                // <Tab fx:id="???">
                // attr.getValue();
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named ButtonBar.
     */
    void visitElement_ButtonBar(org.w3c.dom.Element element) {
        // <ButtonBar>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("layoutX")) {
                // <ButtonBar layoutX="???">
                // attr.getValue();
            }
            if (attr.getName().equals("layoutY")) {
                // <ButtonBar layoutY="???">
                // attr.getValue();
            }
            if (attr.getName().equals("prefHeight")) {
                // <ButtonBar prefHeight="???">
                // attr.getValue();
            }
            if (attr.getName().equals("prefWidth")) {
                // <ButtonBar prefWidth="???">
                // attr.getValue();
            }
            if (attr.getName().equals("fx:id")) {
                // <ButtonBar fx:id="???">
                // attr.getValue();
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("buttons")) {
                        visitElement_buttons(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named buttons.
     */
    void visitElement_buttons(org.w3c.dom.Element element) {
        // <buttons>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("Button")) {
                        visitElement_Button(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named Button.
     */
    void visitElement_Button(org.w3c.dom.Element element) {
        // <Button>
        // element.getValue();
        org.w3c.dom.NamedNodeMap attrs = element.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attrs.item(i);
            if (attr.getName().equals("mnemonicParsing")) {
                // <Button mnemonicParsing="???">
                // attr.getValue();
            }
            if (attr.getName().equals("onAction")) {
                // <Button onAction="???">
                // attr.getValue();
            }
            if (attr.getName().equals("style")) {
                // <Button style="???">
                // attr.getValue();
            }
            if (attr.getName().equals("text")) {
                // <Button text="???">
                // attr.getValue();
            }
            if (attr.getName().equals("fx:id")) {
                // <Button fx:id="???">
                // attr.getValue();
            }
        }
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }
    
}
