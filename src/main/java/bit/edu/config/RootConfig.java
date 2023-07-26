package bit.edu.config;

import bit.edu.Base;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Configuration
@ComponentScan(basePackageClasses = Base.class, excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
}
