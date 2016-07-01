package rnatranscription;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RnaTranscriptionTest {

	@Test
	public void test_ofDna_InvalidInput_NullString_ThrowsException() {
		try {
			RnaTranscription.ofDna( null );
			fail("Supposed to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Expected to catch NullPointerException");
		}
	}
	
    @Test
    public void testRnaTranscriptionOfEmptyDnaIsEmptyRna() {
        Assert.assertEquals("", RnaTranscription.ofDna(""));
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        Assert.assertEquals("G", RnaTranscription.ofDna("C"));
    }

    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assert.assertEquals("C", RnaTranscription.ofDna("G"));
    }

    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assert.assertEquals("A", RnaTranscription.ofDna("T"));
    }

    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assert.assertEquals("U", RnaTranscription.ofDna("A"));
    }

    @Test
    public void test_ofDna_InvalidInput_InvalidCharacters_ReturnsExpectedResponse() {
    	Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGFFFFFFFFGTCTTAA"));
    }
    
    @Test
    public void testRnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGGTCTTAA"));
    }
}
