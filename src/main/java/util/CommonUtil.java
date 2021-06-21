package util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.ZoneOffset;

/**
 * Utility class providing common utility functions required for the project
 *
 */
@UtilityClass
@Log4j2
public final class CommonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(Include.NON_NULL).setSerializationInclusion(Include.NON_EMPTY);

    /**
     * Returns epoch millis by parsing the date string
     * 
     * @param dateStr
     *            Date string
     * @return Returns epoch millis by parsing the date string
     */
    public static long getEpochMillis(String dateStr) {
        return LocalDate.parse(dateStr).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    /**
     * Converts an object into equivalent pojo class
     *
     * @param obj
     *            Object generic
     * @param classType
     *            Class type to convert to
     * @return Return the data type converted
     */
    public static <T> T convertValue(Object obj, Class<T> classType) {

        return MAPPER.convertValue(obj, classType);
    }

    /**
     * Returns epoch millis by adding the days passed to the date represented as
     * string
     * 
     * @param dateStr
     *            Date String
     * @param plusDays
     *            Number of days to add
     * @return Returns epoch millis by adding the days passed to the date
     *         represented as string
     */
    public static long getEpochMillis(String dateStr, int plusDays) {
        return LocalDate.parse(dateStr).plusDays(plusDays).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public static String beautifyJson(Object json) {
        String response = "";
        try {
            response = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch(Exception e) {
            //
        }
        return response;
    }

    public static String convertToJson(Object obj) {
        final SimpleModule module = new SimpleModule();
        // adding our custom serializer
        module.addSerializer(String.class, new StringSerializer());
        MAPPER.registerModule(module);
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.warn("Error converting to json: ", e);
        }
        return StringUtils.EMPTY;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshall(String xmlString, Class<T> className) throws Exception {

        Unmarshaller unmarshaller = null;
        try {
            unmarshaller = JAXBContext.newInstance(className).createUnmarshaller();

            InputSource inputSource = new InputSource(new StringReader(xmlString));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            dbf.setExpandEntityReferences(false);
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(inputSource);

            return (T) unmarshaller.unmarshal(document);
        } catch (JAXBException | ParserConfigurationException | SAXException | IOException e) {
            log.error("Error during unmarshall: ", e);
            throw new Exception("_invalid_request");
        }
    }

}
