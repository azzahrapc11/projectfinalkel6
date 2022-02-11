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
public class TableModelDetilBuku extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private List<TblDetilTransaksi> list = new ArrayList<TblDetilTransaksi>();
    
    public void updateAll(Collection<TblDetilTransaksi> buku)
    {
        list.clear();
        list.addAll(buku);
        fireTableDataChanged();
    }
    
    public TblDetilTransaksi get(int index)
    {
        return list.get(index);
    }
    
    public void setData(List list)
    {
        this.list = list;
        fireTableDataChanged();
    }
    
    public void insert(TblDetilTransaksi buku)
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
    
    public void update(int index, TblDetilTransaksi buku)
    {
        list.set(index, buku);
        fireTableRowsUpdated(index, index);
    }
    
    public TblDetilTransaksi select(int index)
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
                return list.get(rowIndex).getTblDetilTransaksiPK().getTransKd();
            case 1:
                return list.get(rowIndex).getTblDetilTransaksiPK().getBkKd();
            case 2:
                return list.get(rowIndex).getBkJudul();
            case 3:
                return list.get(rowIndex).getTransQty();
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
                return "Kode Transaksi";
            case 1:
                return "Kode Buku";
            case 2:
                return "Judul Buku";
            case 3:
                return "Jumlah Pinjam";
            default:
                return null;
        }
    }
}
