package de.adesso.modulmanager.modul;

import java.net.http.HttpClient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    HttpClient client = HttpClient.newBuilder().build();

    public Integer calculateCp(List<Integer> moduleIds) {
        return moduleRepository.calculateCpByModuleIds(moduleIds);
    }

    public String createModule(Module module) {
        try {
            moduleRepository.save(module);
            moduleRepository.flush();
            return "Module: " + module.getDescription() + " created successfully!";
        } catch (Exception e) {
            return "An error occurred while creating a new Module with ID: " + module.getModuleId() + " " + e.getMessage();
        }
    }

    public Module getModule(String moduleId) {
        return moduleRepository.findByModuleId(moduleId);
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module updateModule(Module module) {

        Module m = moduleRepository.findByModuleId(module.getModuleId());

        if (module.getDescription() != null) {
            m.setDescription(module.getDescription());
        }

        if (module.getCp() != null) {
            m.setCp(module.getCp());
        }

        moduleRepository.save(m);
        moduleRepository.flush();

        return module;
    }

    public String deleteModule(String moduleId) {
        moduleRepository.delete(moduleRepository.findByModuleId(moduleId));

        return "Student with matriklNr: " + moduleId + " deleted successfully!";
    }

    public boolean checkForModule(String moduleId) {
        Module module = moduleRepository.findByModuleId(moduleId);
        if (module != null) {
            return true;
        } else {
            return false;
        }
    }

}
