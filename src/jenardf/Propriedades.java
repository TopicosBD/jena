/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jenardf;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.vocabulary.VCARD;
import static org.apache.jena.vocabulary.VCARD.uri;

/**
 *
 * @author thiag
 */
public class Propriedades extends VCARD {
    
    private static final Model m = ModelFactory.createDefaultModel();
    
    public static final Property JOB = m.createProperty(getURI() + "JOB" );
}
