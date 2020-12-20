package com.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.testng.AssertJUnit.*;

public class Main {
    public static void main(String[] args){
        Optional<String> a = Optional.of("A");
        assertEquals("A",a.get());

        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        assertFalse(emptyOptional.isPresent());

        assertTrue(emptyOptional.isPresent());
    }
}
