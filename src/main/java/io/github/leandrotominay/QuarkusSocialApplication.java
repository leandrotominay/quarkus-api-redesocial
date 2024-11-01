package io.github.leandrotominay;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Api de test de Rede Social",
                version = "1.0",
                contact = @Contact(
                        name = "Leandro Ramos",
                        url = "https://www.linkedin.com/in/leandro-frco/",
                        email = "leandro.tominay@gmail.com"
                ), license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"

        )

        )
)
public class QuarkusSocialApplication extends Application {

}
