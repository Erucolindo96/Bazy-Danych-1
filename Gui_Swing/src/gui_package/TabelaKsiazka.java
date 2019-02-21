/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_package;

import database_connection.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author erucolindo
 */
public class TabelaKsiazka extends javax.swing.JFrame {

    /**
     * Creates new form TabelaKsiazka
     */
    public TabelaKsiazka() {
        initComponents();
        selectTableAndWrite();
    }
    
    private String getAutor(Integer idKsiazka) throws SQLException
    {
        String autorzy = new String("");
        int idAutora;
        Connection c = DataBaseConnection.openConnection();
        Statement stm = c.createStatement(), stm_posredni = c.createStatement();
        ResultSet posrednia_tabela = stm_posredni.executeQuery("SELECT Autor_idAutor FROM mydb.Książka_has_Autor WHERE Książka_idKsiążka = " + idKsiazka);
        ResultSet wynik;
        while(posrednia_tabela.next())
        {
          idAutora = posrednia_tabela.getInt("Autor_idAutor");
          wynik = stm.executeQuery("SELECT * FROM mydb.Autor WHERE idAutor = "+ idAutora);
          
          if(!wynik.next())
              throw new SQLException();
          
          autorzy+=wynik.getString("Imię");
          autorzy+=" ";
          autorzy+=wynik.getString("Nazwisko");
          autorzy+=" \n";  
        }
        stm.close();
        stm_posredni.close();
        return autorzy;
        
    }
    private String getPolka(Integer idPolka)throws SQLException
    {
        Connection c = DataBaseConnection.openConnection();
        Statement stm = c.createStatement();
        ResultSet result = stm.executeQuery("SELECT Nazwa FROM mydb.Półka WHERE idPółka = "+ idPolka);
        if(!result.next())
            throw new SQLException("Nie ma półki o takim ID");
        
        String nazwa = result.getString("Nazwa");
        return nazwa;
    }
    private String getWydawnictwo(Integer idWydawnictwo)throws SQLException
    {
        Connection c = DataBaseConnection.openConnection();
        Statement stm = c.createStatement();
        ResultSet result = stm.executeQuery("SELECT Nazwa FROM mydb.Wydawnictwo WHERE idWydawnictwo = "+ idWydawnictwo);
        if(!result.next())
            throw new SQLException("Nie ma wydawnictwa o takim ID");
        
        String nazwa = result.getString("Nazwa");
        return nazwa;
    }
    private void selectTableAndWrite()
    {
        Connection c = null;
        Statement stm = null;
        ResultSet query_result=null;
        Integer id = null, ilosc = null;
        Float cena = null;
        String tytul = null, autorzy = null, polka = null, Wydawnictwo = null; 
        try
        {
            c = DataBaseConnection.openConnection();
            stm = c.createStatement();
            query_result = stm.executeQuery("SELECT * FROM mydb.Książka") ;
           // wydawnictwo_stm = c.createStatement();            
        }
        catch(SQLException e)
        {
            System.err.println("Nie udało się przeprowadzić zapytania do tabeli Książka: error "+e.getErrorCode());
            return;
        }
        try
        {
            Integer id_wydawnictwo, id_polka;
            int i = 0;
            while(query_result.next())
            {
                if(i == jTable1.getRowCount())
                    break;
                
                id = query_result.getInt("idKsiążka");
                jTable1.setValueAt(id, i, 0);
                
                tytul = query_result.getString("Tytuł");
                jTable1.setValueAt(tytul, i, 1);
                
                cena = query_result.getFloat("Cena");
                jTable1.setValueAt(cena, i, 2);
                
                ilosc = query_result.getInt("Ilość_książek");
                jTable1.setValueAt(ilosc, i, 3);
                //pytamy o autorów
                try
                {
                  autorzy  = getAutor(id);
                  jTable1.setValueAt(autorzy, i, 4);
                }catch(SQLException e)
                {
                    System.out.println("Nie udalo się wypisać autorów: "+ e.getMessage());
                }
                //o półki
                try{
                id_polka = query_result.getInt("Półka_idPółka");
                polka = getPolka(id_polka);
                jTable1.setValueAt(polka, i, 5);
                }catch(SQLException e)
                {
                    System.out.println("Nie udalo się wypisać półki: "+ e.getMessage());
                }
                //i o wydawnictwo
                try{
                id_wydawnictwo = query_result.getInt("Wydawnictwo_idWydawnictwo");
                Wydawnictwo = getWydawnictwo(id_wydawnictwo);
                jTable1.setValueAt(Wydawnictwo, i, 6);
                }catch(SQLException e)
                {
                    System.out.println("Nie udalo się wypisać wydawnictwa: " + e.getMessage());
                }
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(680, 680));

        jPanel2.setPreferredSize(new java.awt.Dimension(600, 680));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(680, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Tytuł", "Cena", "Ilość Książek", "Autorzy", "Półka", "Wydawnictwo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Short.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TabelaKsiazka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelaKsiazka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelaKsiazka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaKsiazka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelaKsiazka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
