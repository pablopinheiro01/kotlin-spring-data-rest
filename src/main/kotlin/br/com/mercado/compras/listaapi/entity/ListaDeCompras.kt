package br.com.mercado.compras.listaapi.entity

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class ListaDeCompras(
    @Id @GeneratedValue
    var id: Long? = null,
    var produto: String? = null,
    var preco: Double? = null,
    var quantidade: Int? = 0
)

/*
{
    "_links": {
        "listaDeComprases": {
            "href": "http://localhost:8080/api/listas"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile"
        }
    }
}
 */
@RepositoryRestResource(path = "listas")
interface ListaDeComprasRepository: CrudRepository<ListaDeCompras, Long>{

    @RestResource(exported = false) //desabilitando delecao tenho que desabilitar ambos os metodos
    override fun deleteById(id: Long)

    @RestResource(exported = false) // desabilito uma funcionalidade da api
    override fun delete(entity: ListaDeCompras)

}