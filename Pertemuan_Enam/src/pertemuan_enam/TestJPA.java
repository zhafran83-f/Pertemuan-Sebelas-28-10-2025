/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan_enam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lenovo IP 330-14IKB
 */
public class TestJPA {

    public static void main(String[] args) {
        System.out.println("🔍 Testing JPA Connection...");

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            // Test 1: Create EntityManagerFactory
            System.out.println("1. Creating EntityManagerFactory...");
            emf = Persistence.createEntityManagerFactory("Pertemuan_EnamPU");
            System.out.println("   ✅ EntityManagerFactory created!");

            // Test 2: Create EntityManager
            System.out.println("2. Creating EntityManager...");
            em = emf.createEntityManager();
            System.out.println("   ✅ EntityManager created!");

            // Test 3: Simple query
            System.out.println("3. Testing database query...");
            Long count = (Long) em.createQuery("SELECT COUNT(b) FROM Buku b").getSingleResult();
            System.out.println("   ✅ Query successful! Total books: " + count);

            System.out.println("🎉 JPA TEST BERHASIL! Semua dependencies lengkap.");

        } catch (Exception e) {
            System.out.println("❌ JPA TEST GAGAL!");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

            // Tunjukkan missing dependency
            if (e.getMessage().contains("ClassNotFoundException")) {
                System.out.println("📌 Missing dependency detected!");
            }
        } finally {
            // Clean up
            if (em != null && em.isOpen()) {
                em.close();
                System.out.println("4. EntityManager closed.");
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
                System.out.println("5. EntityManagerFactory closed.");
            }
        }
    }
}
