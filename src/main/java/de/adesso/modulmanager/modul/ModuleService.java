package de.adesso.modulmanager.modul;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
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

 /*    public Module updateModule(Module module) {
        moduleRepository.updateModulebyModuleById(module.getModuleId(), module.getDescription());
        moduleRepository.flush();
        return module;
    }
 */
    public String deleteModule(int moduleId) {

        moduleRepository.delete(moduleRepository.findByModuleId(moduleId));

        return "Module " + moduleId + " deleted successfully!";
    }
    
   


}
