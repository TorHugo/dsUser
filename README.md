
# BootCamp - DevSuperior. 
## _**DsCatalog**_:
- Projeto feito a principio para cadastro de usuários, para praticar os estudos aprenditos a partir das aulas mestradas pelo professor _**Nélio Alves**_, porém adicionado também, conhecimentos aprenditos durante o trabalho e outros cursos!     


## _**Stack utilizada**_:
- **_Back-end:_** 
    - Linguagem Java;
    - Banco de dados: H2;
    - Framework: SpringBoot. 
    
- **_Dependencias utilizadas_**:
    - Spring Data JPA;
    - H2 Database;
    - Spring-web;
    - Lombok.

## _**Routes and Methods**_
### _**User**_:

- **New _User_**:

```http
  POST api/user
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `string` | Nome do novo usuário. |
| `cpf` | `string` | Cpf do novo usuário. |
| `income` | `double` | Valor da renda do usuário. |
| `birthDate` | `instant` | Data de nascimento do usuário. Formato esperado: _**2022-07-20T10:00:00Z**_. |
| `children` | `integer` | Quantidade de filhos do usuário. |

```json
    {
      "name": "Victor Hugo",
      "cpf": "35962726880",
      "income": 6500.0,
      "birthDate": "2004-03-19T00:00:00Z",
      "children": 0
    }
```

- **Find by id _User_**:

```http
  GET api/user/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | O ID do usuário que você busca. |

- **Find by page _User_**:

```http
  GET api/user
```

| Parâmetro   | Value       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `page`      | `integer` | Página desejada. |
| `linesPerPage`      | `integer` | Quantidade de linhas por página. |
| `direction`      | `integer` | Descentende ou Ascendente. |
| `orderBy`      | `integer` | Ordena por ID as categorias encontradas. |

- **Update _User_**:

```http
  PUT api/user/${id}
```

| Parâmetro   | Tipo  / Value     | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | O ID da categoria que você quer alterar. |
| `name` | `string` | Novo nome do usuário. |
| `cpf` | `string` | Novo cpf do usuário. |
| `income` | `double` | Novo valor da renda do usuário. |
| `birthDate` | `instant` | Nova data de nascimento do usuário. Formato esperado: _**2022-07-20T10:00:00Z**_. |
| `children` | `integer` | Alteracao da quantidade de filhos do usuário. |


```json
    {
      "name": "Victor Hugo",
      "cpf": "35962726880",
      "income": 6500.0,
      "birthDate": "2004-03-19T00:00:00Z",
      "children": 0
  }
```

- **Delete _User_**:

```http
  DEL api/user/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `integer` | O ID do usuário que você queira deletar. |

## _**Autor**_:

- GitHub: https://github.com/TorHugo
- LinkedIn: https://www.linkedin.com/in/victorhugodev/
- Email: arruda.victorhugo@outlook.com

