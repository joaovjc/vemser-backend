
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
		MongoClient mongoClient = MongoClients.create(uri);

		MongoDatabase mongoDatabase = mongoClient.getDatabase("vemser_back");

		MongoCollection<Document> alunos = mongoDatabase.getCollection("pessoa_java");

		String a = """
						{
					        "nome" : "Rafael Lazzari",
					        "DATA_NASCIMENTO" : new Date (1990,01,27),
					        "cpf" : "12345678912",
					        "sexo" : "M",
					        "peso": 77,
					        "rg" : "44456345234",
					        "cep" : "4151854"
					    }
				""";

		List<Document> documentos = Arrays.asList(Document.parse("""
				{
				    "nome" : "gustavo",
				       "DATA_NASCIMENTO" : new Date (1990,01,27),
				       "sexo" : "M",
				       "peso": 84,
				       "cpf" : "12345678912",
				       "rg" : "151514563332",
				       "cep" : "90670001"
				   }"""), Document.parse("""
				{
				 "nome" : "lucas cunha",
				    "DATA_NASCIMENTO" : new Date (1990,01,27),
				    "sexo" : "M",
				    "peso": 70,
				    "cpf" : "12345678912",
				    "rg" : "151514563332",
				    "cep" : "90670001"
				}"""), Document.parse("""
				{
				  	    "nome" : "lucas machado",
				 	        "DATA_NASCIMENTO" : new Date (1990,01,27),
				 	        "sexo" : "M",
				 	        "peso": 125,
				 	        "cpf" : "12345678912",
				 	        "rg" : "151514563332",
				 	        "cep" : "888465749"
				 	    }"""), Document.parse("""
				{
				 "nome" : "lucas godim",
				    "DATA_NASCIMENTO" : new Date (1990,01,27),
				    "sexo" : "F",
				    "peso": 87,
				    "cpf" : "12345678912",
				    "rg" : "151514563332",
				    "cep" : "90670001"
				}"""), Document.parse("""
				{
				 "nome" : "lucas godim",
				    "DATA_NASCIMENTO" : new Date (1990,01,27),
				    "sexo" : "F",
				    "peso": 70,
				    "cpf" : "12345678912",
				    "rg" : "151514563332",
				    "cep" : "90670001"
				}"""), Document.parse("""
				{
				 "nome" : "joão victor",
				    "DATA_NASCIMENTO" : new Date (1990,01,27),
				    "sexo" : "M",
				    "peso": 60,
				    "cpf" : "12345678912",
				    "rg" : "151514563332",
				    "cep" : "906700015445"
				}"""));

		alunos.insertOne(Document.parse(a));

		alunos.deleteOne(Filters.eq("nome", "Rafael Lazzari"));

		alunos.insertMany(documentos);

		alunos.deleteMany(Filters.eq("sexo", "F"));

		alunos.updateOne(Filters.eq("nome", "lucas godim"),
				new Document("$set", new Document("data_nascimento", new Date(2020 - 1900, 04, 11))));

		Document aluno = alunos.find(new Document("nome", "joão victor")).first();
		System.out.println(aluno);
		
		aluno = alunos.find(Filters.gte("peso", "80")).first();


		mongoClient.close();
	}
}
