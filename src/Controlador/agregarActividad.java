/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import bd.Conexion;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class agregarActividad extends Conexion {

    public boolean agregarTarea(actividadTarea tarea) {

        try {
            Connection conexion = Conexion.getConexion();
            String queryActividad = "INSERT INTO actividatarea(nombre,descripcion) values(?,?)";
            String queryTarea = "INSERT INTO actividatarea(id_ta, fecha, terminada) values((select max(id) from actividad),?,?)";

            PreparedStatement qactividad = conexion.prepareStatement(queryActividad);
            PreparedStatement qtarea = conexion.prepareStatement(queryTarea);

            qactividad.setString(1, tarea.getNombre());
            qactividad.setString(2, tarea.getDescripcion());
            qtarea.setString(1, tarea.getFecha());
            qtarea.setBoolean(2, tarea.isTerminada());

            if (qactividad.executeUpdate() > 0 && qtarea.executeUpdate() > 0) {
                return true;
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error agregar tarea en " + e.getMessage());
        }
        return false;
    }

    public boolean agregarObjetivo(actividadObjetivo objetivo) {

        try {
            Connection conexion = Conexion.getConexion();
            String queryAc = "Insert into actividaobjetivo(nombre,descripcion) values (?,?)";
            String queryOb = "Insert into actividaobjetivo(id_ob, dia,repeticiones) values ((select max(id) from actividad),?,?)";

            PreparedStatement ac = conexion.prepareStatement(queryAc);
            PreparedStatement ob = conexion.prepareStatement(queryOb);

            ac.setString(1, objetivo.getNombre());
            ac.setString(2, objetivo.getDescripcion());

            ob.setString(1, objetivo.getPrimerDia());
            ob.setInt(2, objetivo.getRepeticiones());

            if (ac.executeUpdate() > 0 && ob.executeUpdate() > 0) {
                return true;
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error agregar objetivo en " + e.getMessage());
        }
        return false;
    }
    
    public boolean actualizarObjetivo(actividadObjetivo objetivo, int id){
        
        try {   
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE actividad SET nombre = ?,  descripcion = ? WHERE id = ?";
            String query2 = "UPDATE objetivo SET dia = ?, repeticiones = ? WHERE id_ob = ?;";
            
            PreparedStatement upd1 = conexion.prepareStatement(query);
            PreparedStatement upd2 = conexion.prepareStatement(query2);
            
            upd1.setString(1, objetivo.getNombre());
            upd1.setString(2, objetivo.getDescripcion());
            upd1.setInt(3, id);
            upd2.setString(1, objetivo.getPrimerDia());
            upd2.setInt(2, objetivo.getRepeticiones());
            upd2.setInt(3, id);
            
            if(upd1.executeUpdate()>0&&upd2.executeUpdate()>0){
                return true;
            }
            conexion.close();
                    
        }catch(Exception e){
            System.out.println("Erro en "+e.getMessage());
        }
        return false;
    }
    
    public boolean actualizarTarea(actividadTarea tarea, int id){
    
        try{
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE actividad SET nombre = ?,  descripcion = ? WHERE id = ?";
            String query2 = "UPDATE tarea SET fecha = ?, terminada = ? WHERE id_ta = ?;";

            PreparedStatement upd1 = conexion.prepareStatement(query);
            PreparedStatement upd2 = conexion.prepareStatement(query2);

            upd1.setString(1, tarea.getNombre());
            upd1.setString(2, tarea.getDescripcion());
            upd1.setInt(3, id);
            upd2.setString(1, tarea.getFecha());
            upd2.setBoolean(2, tarea.isTerminada());
            upd2.setInt(3, id);

            if (upd1.executeUpdate() > 0 && upd2.executeUpdate() > 0) {
                return true;
            }
            conexion.close();
            
        
        
        }catch(Exception e) {
            
            System.out.println("Erro en " + e.getMessage());
        }
        
    
        return false;
    }

    public static DefaultTableModel listarObjetivos(String Nombre) {

        DefaultTableModel modelo = new DefaultTableModel();
        String where = "";

        try {
            //Conexin con la base de dato
            Connection conexion = Conexion.getConexion();
            ResultSet rs = null;

            if (!"".equals(Nombre)) {
                where = "WHERE nombre = '" + Nombre + "'";
            }

            String sql = "SELECT id, nombre, descripcion, dia, repeticiones FROM actividaobjetivo " + where;
            PreparedStatement ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Dia");
            modelo.addColumn("Repeticiones en la semana");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            conexion.close();

        } catch (SQLException e) {
            System.out.println("error");

        }
        return modelo;

    }

    public static DefaultTableModel listarTareas(String nombre) {

        String where = "";
        DefaultTableModel modelo = new DefaultTableModel();

        if (!"".equals(nombre)) {
            where = "WHERE nombre = '" + nombre + "'";
        }

        try {

            //Conexin con la base de dato
            Connection conexion = Conexion.getConexion();
            ResultSet rs = null;

            String sql = "SELECT id, nombre, descripcion, fecha, terminada FROM actividatarea " + where;
            PreparedStatement ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Fecha");
            modelo.addColumn("Terminada");

            while (rs.next()) {

                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException e) {
            System.out.println("Error en mostrar tareas ");
        }
        return modelo;
    }

    public boolean eliminarObjetivo(String id) {

        try {
            Connection conexion = Conexion.getConexion();
            String sql1 = "DELETE FROM objetivo where id_ob =" + id;
            String sql2 = "DELETE from actividad where id =" + id;
            
            //DELETE from objetivo where id_ob = (select id  from actividad where nombre = 'Correr');
            //DELETE from actividad where nombre = 'Correr';

            PreparedStatement delet1 = conexion.prepareStatement(sql1);
            PreparedStatement delet2 = conexion.prepareStatement(sql2);

            if (delet1.executeUpdate() > 0 && delet2.executeUpdate() > 0) {
                return true;
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());

        }
        return false;

    }
    
    public boolean eliminarTarea(String id) {

        try {
            Connection conexion = Conexion.getConexion();
            String sql1 = "DELETE FROM tarea where id_ta =" + id;
            String sql2 = "DELETE from actividad where id =" + id;

            
            PreparedStatement delet1 = conexion.prepareStatement(sql1);
            PreparedStatement delet2 = conexion.prepareStatement(sql2);

            if (delet1.executeUpdate() > 0 && delet2.executeUpdate() > 0) {
                return true;
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());

        }
        return false;

    }

}
