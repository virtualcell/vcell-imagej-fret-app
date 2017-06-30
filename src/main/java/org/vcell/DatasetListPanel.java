package org.vcell;

import net.imagej.Dataset;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by kevingaffney on 6/28/17.
 */
public class DatasetListPanel extends JPanel {

    private JList<Dataset> list;

    public DatasetListPanel(ArrayList<Dataset> datasets) {
        setLayout(new BorderLayout());
        list = new JList<>();
        list.setModel(getListModel(datasets));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setCellRenderer(new DefaultListCellRenderer());
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);
    }

    private ListModel<Dataset> getListModel(ArrayList<Dataset> datasets) {
        DefaultListModel<Dataset> listModel = new DefaultListModel<>();
        for (Dataset data : datasets) {
            listModel.addElement(data);
        }
        return listModel;
    }

    public void updateList(ArrayList<Dataset> datasets) {
        list.setModel(getListModel(datasets));
    }

    public Dataset getSelectedDataset() {
        return list.getSelectedValue();
    }
}