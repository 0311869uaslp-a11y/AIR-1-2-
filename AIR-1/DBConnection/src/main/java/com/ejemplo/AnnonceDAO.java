package com.ejemplo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO extends DAO<Annonce> {

    @Override
    public void insert(Annonce annonce) {
        String sql = "INSERT INTO annonce (title, description, adress, mail) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, annonce.getTitle());
            ps.setString(2, annonce.getDescription());
            ps.setString(3, annonce.getAdress());
            ps.setString(4, annonce.getMail());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Annonce annonce) {
        String sql = "UPDATE annonce SET title=?, description=?, adress=?, mail=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, annonce.getTitle());
            ps.setString(2, annonce.getDescription());
            ps.setString(3, annonce.getAdress());
            ps.setString(4, annonce.getMail());
            ps.setInt(5, annonce.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM annonce WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
 // Obtener todas las annonces
    public List<Annonce> getAll() {
        List<Annonce> list = new ArrayList<>();
        String sql = "SELECT * FROM annonce ORDER BY date DESC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Annonce a = new Annonce();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setDescription(rs.getString("description"));
                a.setAdress(rs.getString("adress"));
                a.setMail(rs.getString("mail"));
                a.setDate(rs.getTimestamp("date"));

                list.add(a);

                // Depuración: mostrar cada anuncio
                System.out.println("[DAO] Advertisement found: " + a.getTitle());
            }

            System.out.println("[DAO] Total ads obtained: " + list.size());

        } catch (SQLException e) {
            System.out.println("[DAO] Error getting ads");
            e.printStackTrace();
        }

        return list;
    }
    
    public Annonce getById(int id) {
        String sql = "SELECT * FROM annonce WHERE id=?";
        
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Annonce a = new Annonce();
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                a.setDescription(rs.getString("description"));
                a.setAdress(rs.getString("adress"));
                a.setMail(rs.getString("mail"));
                a.setDate(rs.getTimestamp("date")); // o "created_at" según tu BD
                return a;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
