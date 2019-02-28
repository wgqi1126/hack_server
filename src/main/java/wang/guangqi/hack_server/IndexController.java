package wang.guangqi.hack_server;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("app", "Hack Server");
        return "index";
    }

    @RequestMapping("get-root-cert")
    public ResponseEntity<InputStreamResource> getRootCert() throws FileNotFoundException {
        File file = new File(getClass().getClassLoader().getResource("cert/root.cer").getFile());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.valueOf("application/x-pem-file"))
                .body(resource);
    }
}
