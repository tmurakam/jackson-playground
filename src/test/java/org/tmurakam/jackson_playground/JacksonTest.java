package org.tmurakam.jackson_playground;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTest {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void test1() throws Exception {
        Entity1 e = new Entity1().init();
        String json = mapper.writeValueAsString(e);

        System.out.println(json);

        Entity1 er = mapper.readValue(json, Entity1.class);

        assertThat(er.getFieldIgnoreSetterOnly()).isEqualTo(0); // ignored by setter
        assertThat(er.getFieldJsonSetter()).isEqualTo(4);
    }
}
