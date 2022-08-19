package thomas.backendteknoland.converter;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String dateAuFormatTexte) {
        return LocalDate.parse(dateAuFormatTexte);
    }
}
