package net.charlie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.charlie.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

			Usuario findByUsername(String username);
			
			@Modifying
		    @Query("UPDATE Usuario u SET u.estatus=0 WHERE u.id = :paramIdUsuario")
		    int lock(@Param("paramIdUsuario") int idUsuario);
			
			@Modifying
		    @Query("UPDATE Usuario u SET u.estatus=1 WHERE u.id = :paramIdUsuario")
		    int unlock(@Param("paramIdUsuario") int idUsuario);
}
