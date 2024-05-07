package de.adesso.modulmanager.modul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    public String createModule(Module module) {

        try {
            moduleRepository.save(module);
            moduleRepository.flush();
            return "Module: " + module.getDescription() + " created successfully!";
        } catch (Exception e) {
            System.out.println(
                    "An error occurred while creating a new Module with ID: " + module.getModuleId() + e.getMessage());
        }
        return "AMK";
    }

    public Module getModule(int moduleId) {
        return moduleRepository.findByModuleId(moduleId);
    }

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Module updateModule(Module module) {

        Module m = moduleRepository.findByModuleId(module.getModuleId());

        if (module.getDescription() != null) {
            m.setDescription(module.getDescription());
        } else if (module.getCP() != null) {
            m.setCP(module.getCP());
        }
        return module;
    }

    public String deleteModule(int moduleId) {
        moduleRepository.delete(moduleRepository.findByModuleId(moduleId));
        return "Student with matriklNr: " + moduleId + " deleted successfully!";
    }

    public boolean checkForModule(int moduleId) {
        Module module = moduleRepository.findByModuleId(moduleId);
        if (module != null) {
            return true;
        } else {
            return false;
        }
    }

}
