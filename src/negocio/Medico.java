package negocio;
// Generated 07/10/2017 19:33:54 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Medico generated by hbm2java
 */
@Entity
@Table(name="medico"
    ,catalog="sistemaclinica"
)
public class Medico  implements java.io.Serializable {


     private Integer idMedico;
     private int crm;
     private String nome;
     private String cpf;
     private String especialidade;
     private Date dataNascimento;
     private String endereco;
     private String telefone;
     private Set atestados = new HashSet(0);

    public Medico() {
    }

	
    public Medico(int crm, String nome, String cpf, String especialidade, Date dataNascimento, String endereco) {
        this.crm = crm;
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    public Medico(int crm, String nome, String cpf, String especialidade, Date dataNascimento, String endereco, String telefone, Set atestados) {
       this.crm = crm;
       this.nome = nome;
       this.cpf = cpf;
       this.especialidade = especialidade;
       this.dataNascimento = dataNascimento;
       this.endereco = endereco;
       this.telefone = telefone;
       this.atestados = atestados;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_medico", unique=true, nullable=false)
    public Integer getIdMedico() {
        return this.idMedico;
    }
    
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    
    @Column(name="crm", nullable=false)
    public int getCrm() {
        return this.crm;
    }
    
    public void setCrm(int crm) {
        this.crm = crm;
    }

    
    @Column(name="nome", nullable=false, length=100)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="cpf", nullable=false, length=20)
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    @Column(name="especialidade", nullable=false, length=50)
    public String getEspecialidade() {
        return this.especialidade;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento", nullable=false, length=10)
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    @Column(name="endereco", nullable=false, length=200)
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
    @Column(name="telefone", length=20)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="medico")
    public Set getAtestados() {
        return this.atestados;
    }
    
    public void setAtestados(Set atestados) {
        this.atestados = atestados;
    }




}


