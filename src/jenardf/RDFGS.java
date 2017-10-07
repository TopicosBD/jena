/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jenardf;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
import java.io.PrintWriter;
import java.util.List;
import model.CargoDAO;
import model.FuncionarioDAO;
import negocio.*;

public class RDFGS extends Object {

    public static void main(String args[]) {
        String personURI = "http://tebdjena/";
        String nome;
        String cargo;
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        CargoDAO cargoDAO = new CargoDAO();
        List<Funcionario> listaFuncionario = funcionarioDAO.getFuncionario(15);
        
        // create an empty Model
        Model model = ModelFactory.createDefaultModel();
        
        for(int i = 0; i < listaFuncionario.size(); i++){
            listaFuncionario.get(i).setCargo(cargoDAO.getCargo(listaFuncionario.get(i).getCargo().getIdCargo()));
            nome = listaFuncionario.get(i).getNome();
            cargo = listaFuncionario.get(i).getCargo().getNome();
            
            //and add the properties cascading style
            //create the resource
            Resource johnSmith = model.createResource(personURI + nome)
                                        .addProperty(Propriedades.FN, nome)
                                        .addProperty(Propriedades.JOB, cargo);
        }

        // list the statements in the Model
        StmtIterator iter = model.listStatements();

        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();  // get next statement
            Resource subject = stmt.getSubject();     // get the subject
            Property predicate = stmt.getPredicate();   // get the predicate
            RDFNode object = stmt.getObject();      // get the object

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            } else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }

            System.out.println(" .");
        }
        //System.out.println();
        //model.write(System.out);
        
        try {
            //Mudar URL se necessário
            FileOutputStream fout = new FileOutputStream("C:\\Users\\thiag\\Desktop\\sistemaclinicardf.xml");
            model.write(fout);
        } catch (IOException e) {
            System.out.println("Exception caught" + e.getMessage());
        }
        
    }
}
