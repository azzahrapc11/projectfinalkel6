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
public class TableModelBuku extends AbstractTableModel{
    
    private static final long serialVersionUID = 1L;
    private List<TblBuku> list = new ArrayList<TblBuku>();
    
    public void updateAll(Collection<TblBuku> buku)
    {
        list.clear();
        list.addAll(buku);
        fireTableDataChanged();
    }
    
    public TblBuku get(int index)
    {
        return list.get(index);
    }
    
    public void setData(List list)
    {
        this.list = list;
        fireTableDataChanged();
    }
    
    public void insert(TblBuku buku)
    {
        list.add(buku);
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
    
    public void update(int index, TblBuku buku)
    {
        list.set(index, buku);
        fireTableRowsUpdated(index, index);
    }
    
    public TblBuku select(int index)
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
        return 7;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:
                return list.get(rowIndex).getBkKd();
            case 1:
                return list.get(rowIndex).getBkJudul();
            case 2:
                return list.get(rowIndex).getBkPengarang();
            case 3:
                return list.get(rowIndex).getBkPenerbit();
            case 4:
                return list.get(rowIndex).getBkTahunTerbit();
            case 5:
                return list.get(rowIndex).getBkStok();
            case 6:
                return list.get(rowIndex).getBkStatus();
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
                return "Kode Buku";
            case 1:
                return "Judul Buku";
            case 2:
                return "Pengarang";
            case 3:
                return "Penerbit";
            case 4:
                return "Tahun Terbit";
            case 5:
                return "Stok";
            case 6:
                return "Status";
            default:
                return null;
        }
    }
}
