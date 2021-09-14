package br.com.rd.ProjetoServico.Repository.contract;

import br.com.rd.ProjetoServico.Model.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
}
