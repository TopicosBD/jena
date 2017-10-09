
package jenardf;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class ConsultaSparql {
    
    public static void main(String args[]) {
        
        Model model = FileManager.get().loadModel("sistemaclinicardf.rdf");
        
        /*
        Pesquisar por funcionários que têm cargo Bailarino
        String queryString = 
                "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX vcard:<http://www.w3.org/2001/vcard-rdf/3.0#>" +
                "SELECT ?nome  " +
                "WHERE {" +
                " ?prefixo vcard:FN ?nome ." +
                " ?prefixo vcard:JOB \"Bailarino\" ." +
                "}";
        */
        
        //Pesquisar por todos os funcionários
        String queryString = 
                "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                "PREFIX vcard:<http://www.w3.org/2001/vcard-rdf/3.0#>" +
                "SELECT ?nome ?cargo " +
                "WHERE {" +
                " ?prefixo vcard:FN ?nome ." +
                " ?prefixo vcard:JOB ?cargo ." +
                "}";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();

        // Output query results 
        ResultSetFormatter.out(System.out, results, query);

        // Important - free up resources used running the query
        qe.close();
        
    }
    
}
