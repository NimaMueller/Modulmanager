package de.adesso.modulmanager.modul;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, String> {

    Module findByModuleId(String moduleId);

    @Transactional
    @Query("Select SUM(cp) from Module where moduleId in :moduleIds")
    Integer calculateCpByModuleIds(@Param("moduleIds") List<Integer> moduleIds);

}
