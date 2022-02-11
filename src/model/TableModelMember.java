/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class TableModelMember extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private List<TblMember> list = new ArrayList<TblMember>();
    
    public void updateAll(Collection<TblMember> member)
    {
        list.clear();
        list.addAll(member);
        fireTableDataChanged();
    }
    
    public TblMember get(int index)
    {
        return list.get(index);
    }
    
    public void setData(List list)
    {
        this.list = list;
        fireTableDataChanged();
    }
    
    public void insert(TblMember member)
    {
        list.add(member);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
    
    public void delete(int index)
    {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public void deleteall(){
        list.clear(); 
        fireTableDataChanged();
    }
    
    public void update(int index, TblMember member)
    {
        list.set(index, member);
        fireTableRowsUpdated(index, index);
    }
    
    public TblMember select(int index)
    {
        return list.get(index);
    }
    
    @Override
    public int getRowCount()
    {
        return list.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:
                return list.get(rowIndex).getMbKd();
            case 1:
                return list.get(rowIndex).getMbNama();
            case 2:
                return list.get(rowIndex).getMbNoHp();
            case 3:
                return list.get(rowIndex).getMbAlamat();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column)
    {
        switch(column)
        {
            case 0:
                return "Kode Member";
            case 1:
                return "Nama Member";
            case 2:
                return "Nomor HP";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }
    
}
