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
public class TableModelPeminjaman extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private List<TblTransaksi> list = new ArrayList<TblTransaksi>();
    
    public void updateAll(Collection<TblTransaksi> transaksi)
    {
        list.clear();
        list.addAll(transaksi);
        fireTableDataChanged();
    }
    
    public TblTransaksi get(int index)
    {
        return list.get(index);
    }
    
    public void setData(List list)
    {
        this.list = list;
        fireTableDataChanged();
    }
    
    public void insert(TblTransaksi transaksi)
    {
        list.add(transaksi);
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
    
    public void update(int index, TblTransaksi transaksi)
    {
        list.set(index, transaksi);
        fireTableRowsUpdated(index, index);
    }
    
    public TblTransaksi select(int index)
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
                return list.get(rowIndex).getTransKd();
            case 1:
                return list.get(rowIndex).getTransTglTransaksi();
            case 2:
                return list.get(rowIndex).getMbKd();
            case 3:
                return list.get(rowIndex).getTransTglPinjam();
            case 4:
                return list.get(rowIndex).getTransTglKembali();
            case 5:
                return list.get(rowIndex).getStatusPengembalian();
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
                return "Tanggal Transaksi";
            case 2:
                return "Kode Member";
            case 3:
                return "Tanggal Pinjam";
            case 4:
                return "Tanggal Kembali";
            case 5:
                return "Status";
            default:
                return null;
        }
    }
}
