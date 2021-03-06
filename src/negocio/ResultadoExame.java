package negocio;
// Generated 07/10/2017 19:33:54 by Hibernate Tools 4.3.1


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

/**
 * ResultadoExame generated by hbm2java
 */
@Entity
@Table(name="resultado_exame"
    ,catalog="sistemaclinica"
)
public class ResultadoExame  implements java.io.Serializable {


     private Integer idTipoResultadoExame;
     private String tipo;
     private Set exames = new HashSet(0);

    public ResultadoExame() {
    }

	
    public ResultadoExame(String tipo) {
        this.tipo = tipo;
    }
    public ResultadoExame(String tipo, Set exames) {
       this.tipo = tipo;
       this.exames = exames;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_tipo_resultado_exame", unique=true, nullable=false)
    public Integer getIdTipoResultadoExame() {
        return this.idTipoResultadoExame;
    }
    
    public void setIdTipoResultadoExame(Integer idTipoResultadoExame) {
        this.idTipoResultadoExame = idTipoResultadoExame;
    }

    
    @Column(name="tipo", nullable=false, length=30)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="resultadoExame")
    public Set getExames() {
        return this.exames;
    }
    
    public void setExames(Set exames) {
        this.exames = exames;
    }




}


