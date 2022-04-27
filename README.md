# MaratonaJSF
JFS possui tags que vão ser transformadas em HTML puro.

Namespaces JSF:
- xmlns:h --> referência as tags HTML
- xmlns:ui --> ligado a templates
- xmlns:f --> internacionalização, ajax e drop down
- xmlns:p --> biblioteca do prime faces
 
 
concatenação em JSF --> nome += sobrenome

Palavras reservadas:
and, or, not, eq, ne, lt, gt, le, ge, true, false, null, instanceof, empty, div, mod

Beans - são os controllers no JSF
- anotação @Named --> serve para dizer que uma classe é um managed bean (Bean gerenciável)

Difereça entre Web Application: Archive e Exploded
- Com o Exploded voce pode salvar alterações no arquivo sem precisar reiniciar o servidor(Hot deploy)

Hot deploy - algumas coisas podem ser alteradas sem ter que reiniciar o servidor para serem apresentadas
- alterações na view
- modificações em uma classe java apenas no corpo de um método
- quaisquer outras alterações, deverão contar com o reinício do servidor


**EXPRESSION LANGUAGE**
- pegar um valor ou colocar um valor dentro do Bean 
- JSP ${valor} - permite apenas fazer a leitura de dados, exibir os dados
- JSF #{valor} - permite fazer tanto a leitura como a escrita de valores, ou seja, serão chamados tanto os gets como os sets

*Operações Lógicas*
and - &&
or - ||
not - !
eq - ==
ne - !=
lt - <
gt - >
le - <=
ge - >=
true - verdadeiro (1)
false - falso (0)
null - nulo
instanceof - 
empty - 
div - divisão
mod - resto

*Coleções*
Diferença entre:
- action: espera uma String como retorno, essa String é o nome da página que você desejar ir quando executar o método
- actionListener: não espera nenhum tipo de retorno, vai executar, mas retornará void

*CSS e Javascript em JSF*
atributos
- style --> para colocar CSS puro
- styleClass --> para coloca uma classe CSS

*Esconder a exibição de elementos da tela*
@ViewScoped - enquanto o usuário estiver na página, os estados dos objetos devem ser mantidos, por mais que o usuário faça requisições

*Requisição AJAX*
- requisição parcial, carregará apenas parte do Bean, somente o que for pedido na requisição
- o retorno sempre será void
- ATENÇÃO: - uso da tag head
	     - anotação @ViewScoped
	     - ui:fragment n renderiza html, funciona como um if

 
*Lambdas*
Ex:
	#{(soma -> soma +num)(10)}<br/>
	#{((v1, v2, v3) -> v1*v2*v3)(1,5,10)}<br/>
	#{(x -> x*x*x)(2)}<br/>
	#{cubo=(x -> x*x*x); cubo(2)}<br/>
	#{cubo(10)}


*Lists*
	<ui:repeat value="#{['Peaky', 'Blinders']}" var="mensagem">
            #{mensagem}
     </ui:repeat><br/>


*Set*
- set não mantém a ordem
- apresenta apenas uma vez valores repetidos
Ex:
	<ui:repeat value="#{{'Peaky', 'Blinders','Blinders', 'blinders'}}" var="mensagem">
            #{mensagem}
	</ui:repeat><br/>


*Map*
- mesma sintaxe do Set
- diferente pq com Map tem usa-se cheve : valor (key : value)
<ui:repeat value="#{{'Melhor personagem':'Tobey Shelby', 'Pior personagem':'Michael Shelby', 'Melhor série':'Peaky Blinders'}}" var="mensagem">
            <ui:repeat value="#{mensagem}" var="entry">
                #{entry.key} - #{entry.value}
            </ui:repeat>
        </ui:repeat><br/>


*Streams*
Ex:
	#{numerosList.stream().average().get()}<br/>
	#{numerosList.stream().sum()}



*JSTL*
- permite criar variáveis dentro da view
- "xmlns:c"




**ESCOPOS CDI**
- anotações no qual se vai dizer quanto tempo um Bean vai ficar vivo
São elas:
	- @RequestScoped
	- @ViewScoped
	- @SessionScoped
	- @ApplicationScoped
	- @ConversationScoped
	- @FlowScoped
	- @Dependent

*@RequestScoped*
- vai ficar vivo durante a requisição http
- a cada início de requisição as variáveis e métodos são criados, e ao fim de cada requisição eles morrem
- utilização quando vai apenas exibir dados para o usuário
- não irá fazer nenhuma outra chamada
- forward X redirect
	- Forward: requisição ao servidor --> servidor retorna oq é desejado, ou seja, os valores ficarão vivos dentro da managed Bean.
	- Redirect: requisição ao servidor --> servidor retorna --> nova requisição --> servidor retorna oq é desejado, ou seja, o RequestScoped vai morrer dentro da segunda requisição.
	
	pq se implemta o serializable, porque muitos containers requerem que os beans sejam serializáveis

*@SessionScoped*
- tudo ficará vivo enquanto a sessão estiver ativa
- se perde a sessão quando fecha o navegador ou quando chama-se um método que invalida a sessão
- Quando utilizar:
	- quando um determinado atributo necessitar ser utilizado em outras páginas e outros beans 
	- Ex: logins, carrinho de compras...

*@ViewScoped*
- objetos ficam vivos enquanto permanecer na mesma aba
- abrir nova aba, os objetos morrem


*@ApplicationScoped*
- Objetos ficam vivos enquanto a API está rodando 
- será executado apenas uma vez (quando o servidor for iniciado)
- qualquer página pode acessar informações

*@FlowScoped*
- Objetos ficam vivos enquanto o usuário permanecer na navegação do Flow
- apenas as páginas do flow podem acesssar informações

@PostConstruct
- inicializar atributos no momento da criação
- método com essa anotação vai ser executado após os atributos do construtor serem inicializados, executado pelo container

@Dependent
- Scopo padrão
- Criado e destruído todas as vezes que é chamado
- fica vivo de acordo com o escopo que for injetado


Injeção de Beans
- usa-se a anotação @Inject para fazer injeções em Beans
- pode-se injetar dentro de um escopo outro escopo que seja mais abrangente 
- Ex: @RequestScoped --> ApplicationScoped, SessionScoped, RequestScoped e Dependent

@ViewScoped -->  ApplicationScoped, SessionScoped, RequestScoped* e Dependent

@RequestScoped --> toda vez que esse request scoped for chamado, os atributos serão criados novamente

@SessionScoped --> ApplicationScoped, SessionScoped e Dependent

@ApplicationScoped --> Dependent

Definindo variáveis globais no sistema
- Usando xml
- Usando ApplicationScope

f:attribute --> adiciona atributos aos componetes, busca atributos dentro do Bean
