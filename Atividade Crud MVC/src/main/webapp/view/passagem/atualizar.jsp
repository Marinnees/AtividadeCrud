<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Passagem</title>

<!-- CDN CSS Bootstrap v-5.1 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
</head>
<body>
	<main>
		<header class="header">
			<div class="row my-4">
				<div class="col">
					<h1>Atualizar Passagem</h1>
				</div>
			</div>

		</header>

		<div class="container py-3">
			<form action="./atualizar-passagem">

				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Id da Passagem </label> <input
						type="text" id="id" name="id" class="form-control"
						value="<%=request.getAttribute("id")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Insira a nova Empresa </label> <input
						type="text" id="empresa" name="empresa" class="form-control"
						value="<%=request.getAttribute("empresa")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Insira o novo local de Embarque </label> <input
						type="text" id="embarque" name="embarque" class="form-control"
						value="<%=request.getAttribute("embarque")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Insira o novo local de Desembarque </label> <input
						type="text" id="desembarque" name="desembarque" class="form-control"
						value="<%=request.getAttribute("desembarque")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Insira o novo valor da Passagem</label> <input
						type="text" id="valor" name="valor" class="form-control"
						value="<%=request.getAttribute("valor")%>" />
				</div>

				<button type="submit" class="btn btn-primary">Enviar</button>

				<a href="./pasagem" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
		</div>

	</main>

	<!-- CDN JS Bootstrap v-5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>