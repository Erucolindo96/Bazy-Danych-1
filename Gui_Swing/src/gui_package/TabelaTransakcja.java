/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import database_connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erucolindo
 */
public class TabelaTransakcja extends javax.swing.JFrame {

    /**
     * Creates new form TabelaTransakcja
     */
    public TabelaTransakcja() {
        initComponents();
        selectTableAndWrite();
    }
    private String getKsiazka(Integer id_ksiazka)throws SQLException
    {
        Connection c = DataBaseConnection.openConnection();
        Statement stm = c.createStatement();
        ResultSet result = stm.executeQuery("SELECT Tytuł FROM mydb.Książka WHERE idKsiążka = "+ id_ksiazka);
        if(!result.next())
            throw new SQLException("Nie ma książki o takim ID");
        String tytul = result.getString("Tytuł");
        stm.close();
        return tytul;
        
    }
    private String getNazwaKontrahenta(Integer id_kontrahenta, boolean czyDostawa)throws SQLException
    {
        String query = new String();
        String nazwa = null;
        if(czyDostawa)
            query = "SELECT Nazwa FROM mydb.Dostawca WHERE idDostawca = "+id_kontrahenta.toString();
        else
            query = "SELECT Nazwa FROM mydb.Klient WHERE idKlient = "+ id_kontrahenta.toString();
        
        Connection c = DataBaseConnection.openConnection();
        Statement stm = c.createStatement();
        ResultSet result = stm.executeQuery(query);
        if(!result.next())
            throw new SQLException("Nie znaleziono kontrahenta o zadanym ID");
        nazwa = result.getString("Nazwa");
        stm.close();
        return nazwa;
        
    }
    private void selectTableAndWrite()
    {
        Connection c = null;
        Statement stm = null;
        ResultSet query_result=null;
        Integer id = null, id_kontrahenta = null, ilosc_ksiazek = null;
        Float wartosc = null;
        Date data = null;
        String nazwa_ksiazki = null, nazwa_kontrahenta = null; 
        try
        {
            c = DataBaseConnection.openConnection();
            stm = c.createStatement();
            query_result = stm.executeQuery("SELECT * FROM mydb.Transakcja");
            
        }
        catch(SQLException e)
        {
            System.err.println("Nie udało się przeprowadzić zapytania do tabeli Transakcja");
            return;
        }
        try
        {
            int i = 0;
            boolean czyDostawa;
            Integer id_ksiazka = null;
            while(query_result.next())
            {
                if(i == jTable1.getRowCount())
                    break;
                
                id = query_result.getInt("idTransakcja");
                jTable1.setValueAt(id, i, 0);
                
                try{
                    id_ksiazka = query_result.getInt("Książka_idKsiążka");
                    nazwa_ksiazki = getKsiazka(id_ksiazka);
                    jTable1.setValueAt(nazwa_ksiazki, i, 1);
                }catch(SQLException e)
                {
                    System.err.println("Nie udało się odczytać tytułu" + e.getMessage());
                }
                //sprawdzamy kto dokonał transakcji
                czyDostawa = query_result.getBoolean("CzyDostawa");
                if(czyDostawa)
                {
                    jTable1.setValueAt("Kupno", i, 2);
                    id_kontrahenta = query_result.getInt("Dostawca_idDostawca");
                }
                else
                {
                    jTable1.setValueAt("Sprzedaż", i, 2);
                    id_kontrahenta = query_result.getInt("Klient_idKlient");
                }
                //wczytujemy dane kontrahenta
                try{
                    nazwa_kontrahenta = getNazwaKontrahenta(id_kontrahenta, czyDostawa);
                    jTable1.setValueAt(nazwa_kontrahenta, i, 3);
                    jTable1.setValueAt(id_kontrahenta, i, 4);
                }catch(SQLException e)
                {
                    System.err.println("Nie znaleziono kontrahenta"+ e.getMessage());
                }
                
                data = query_result.getDate("Data");
                jTable1.setValueAt(data, i, 5);
                
                wartosc = query_result.getFloat("Wartość_Tr");
                jTable1.setValueAt(wartosc, i, 6);
                
                ilosc_ksiazek = query_result.getInt("Ilość_książek");
                jTable1.setValueAt(ilosc_ksiazek, i, 7);
                ++i;
            }
            //teraz usuwamy niepotrzebne kolumny
            if(i<jTable1.getRowCount())
                jTable1.removeRowSelectionInterval(i, jTable1.getRowCount() - 1);
    
            stm.close();
            DataBaseConnection.closeConnection();
        }catch(SQLException e)
        {
            System.err.println("Błąd przy wpisywaniu do tabeli");
        }
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nazwa Książki", "Kupno czy Sprzedaż", "Nazwa Kontrahenta", "Id Kontrahenta", "Data", "Wartość Transakcji", "Ilość Książek"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.setPreferredSize(new java.awt.Dimension(800, 800));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Oblicz zysk pomiędzy podanymi datami");

        jLabel2.setText("Data początkowa");

        jLabel3.setText("Data końcowa");

        jButton1.setText("Oblicz !");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Zysk:");

        jTextField7.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                    .addComponent(jTextField4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                    .addComponent(jTextField5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                    .addComponent(jTextField6)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jButton1)))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 258, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Float obliczZysk(Date data_pocz, Date data_konc)throws SQLException
    {
        Date pobrana_data;
        Float zysk = new Float(0), temp;
        Connection c = DataBaseConnection.openConnection();
        Statement stm = c.createStatement();
        ResultSet result = stm.executeQuery("SELECT czyDostawa,Data, Wartość_Tr FROM mydb.Transakcja");
        
        int i = 0;
        boolean czy_dostawa;
        while(result.next())
        {
            pobrana_data = result.getDate("Data");
            if(pobrana_data.before(data_konc) && pobrana_data.after(data_pocz))
            {
                if(result.getBoolean("czyDostawa") )//odejmujemy od zysku
                {//bo to dostawa, wiec my płacimy
                    zysk-=result.getFloat("Wartość_Tr");
                }
                else//dodajemy do zysku
                {//bo to transakcja sprzedaży
                    zysk+=result.getFloat("Wartość_Tr");
                }
            }
        }
        stm.close();
        DataBaseConnection.closeConnection();
        return zysk;
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dzien, miesiac, rok;
        int dzien_pocz=0, miesiac_pocz=0, rok_pocz=0;
        int dzien_konc=0, miesiac_konc=0, rok_konc=0;
        
        dzien = jTextField1.getText();
        miesiac = jTextField2.getText();
        rok = jTextField3.getText();
        try{
          dzien_pocz = Integer.valueOf(dzien);
          miesiac_pocz = Integer.valueOf(miesiac);
          rok_pocz = Integer.valueOf(rok);
        
          dzien = jTextField4.getText();
          miesiac = jTextField5.getText();
          rok = jTextField6.getText();
        
      
          dzien_konc = Integer.valueOf(dzien);
          miesiac_konc = Integer.valueOf(miesiac);
          rok_konc = Integer.valueOf(rok);
        }
        catch(NumberFormatException e)
        {
            System.err.println("Nieprawidłowy format daty");
            DateFormatError warning = new DateFormatError(this, true);
            jTextField7.setText("");
            warning.setVisible(true);
        }
        Date data_pocz, data_konc;
        data_pocz = new Date(rok_pocz-1900, miesiac_pocz-1, dzien_pocz);
        data_konc = new Date(rok_konc-1900, miesiac_konc-1, dzien_konc);        
        try{
            Float zysk = obliczZysk(data_pocz, data_konc);
            jTextField7.setText(zysk.toString());
        }catch(SQLException e)
        {
            System.err.println("Nie można obliczyć zysku" + e.getMessage());
        }
        //wypisujemy wynik
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TabelaTransakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaTransakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaTransakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaTransakcja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaTransakcja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
