package cat.smap.web.starter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/get-started")
@Tag(name = "StarterKit", description = "Guia de característiques del projecte base")
public class StarterKitController {

    @Operation(summary = "Retorna les característiques incloses al starter-kit")
    @GetMapping
    public ResponseEntity<String> getStarterKitInfo() throws IOException {
        ClassPathResource resource = new ClassPathResource("statics/get-started.json");
        String content = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        return ResponseEntity.ok(content);
    }
}
