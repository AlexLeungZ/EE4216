/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ee4216.springdata.others;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vanting
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
