
//variables globales
var ulVehiculos;
var ulVehiculosBaja;
var vehiculos = [];
var vehiculoSeleccionado;

window.addEventListener('load', function(){

    console.info('documento cargado y listo');    
    ulVehiculos = document.getElementById('ulVehiculo');
    ulVehiculosBaja = document.getElementById('ulVehiculoBaja');
    refrescarLista();
    refrescarListaBajas();

});


function refrescarLista(){

    console.trace('refrescarLista');
    ulVehiculos.innerHTML = '<li class="list-group-item">Cargando vehiculos....</li>';

    let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 && xhr.status==200){   
            let lis='';
            vehiculos=JSON.parse(xhr.responseText);
            vehiculos.forEach((vehiculo,index)=>{
                lis+=`<li class="list-group-item">
                <span class="matricula">${vehiculo.matricula}</span> 
                <span class="modelo">${vehiculo.modelo}</span>
                <span class="km"> ${vehiculo.km} KM</span>
                <a class="mr-3 btn btn-outline-danger" onclick="eliminar(${vehiculo.id})">Eliminar</a>
                <a class="mr-3 btn btn-outline-danger" onclick="bajaorecuperar(${vehiculo.id},"baja")">Dar de baja</a>
                <a class="mr-3 btn btn-outline-info" onclick="cargarDatos(${vehiculo.id})">Editar</a>
            </li>`;
            });
            ulVehiculos.innerHTML=lis;
        }    
   };
   xhr.open('GET', 'http://localhost:8080/wsrest/api/vehiculo/?baja=false');
   xhr.send( );
} // refrescarLista

function refrescarListaBajas(){

    ulVehiculosBaja.innerHTML = '<li class="list-group-item">Cargando vehiculos....</li>';

    let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 && xhr.status==200){   
            let lis='';
            vehiculos=JSON.parse(xhr.responseText);
            vehiculos.forEach((vehiculo,index)=>{
                lis+=`<li class="list-group-item">
                <span class="matricula">${vehiculo.matricula}</span> 
                <span class="modelo">${vehiculo.modelo}</span>
                <span class="km"> ${vehiculo.km} KM</span>
                <a class="mr-3 btn btn-outline-success" onclick="bajaorecuperar(${vehiculo.id},"recuperar")">Restaurar</a>
            </li>`;
            });
            ulVehiculosBaja.innerHTML=lis;
        }    
   };
   xhr.open('GET', 'http://localhost:8080/wsrest/api/vehiculo/?baja=true');
   xhr.send( );
} // refrescarLista

function eliminar( id ){


    if ( confirm('¿Estas Seguro?') ){
        let xhr = new XMLHttpRequest();    
        xhr.onreadystatechange = function(){ 
             if (xhr.readyState == 4 ){   
                 if(xhr.status==200){
                    showAlert("Vehiculo eliminado","success");
                    refrescarLista();
                 }else if(xhr.status==409){
                    showAlert("El vehiculo tiene multas asociadas, no puede ser eliminado","danger");
                 }
                 console.debug(' STATUS ' + xhr.status );
             }    
        };
        xhr.open('DELETE', 'http://localhost:8080/wsrest/api/vehiculo/'+id);
        xhr.send( );
    }    
    
} // eliminar


function crear(){
    console.log('click crear' );

    let matricula = document.getElementById('matricula').value;
    let modelo = document.getElementById('modelo').value;
    let km = document.getElementById('Km').value;

    let jsonCoche = {
        "matricula" : matricula,
        "modelo": modelo,
        "km": km
    };

   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4){   
            if(xhr.status==201){
                showAlert("Vehiculo agregado","success"); 
            }else if(xhr.status==404){
                showAlert("Parametros incorrectos","danger"); 
            }else if(xhr.status==409){
                showAlert("esa matricula ya existe","danger"); 
            }else if(xhr.status==500){
                showAlert("exiten errores en los datos","danger"); 
            }
            refrescarLista();
        }    
   };
   xhr.open('POST', 'http://localhost:8080/wsrest/api/vehiculo/');
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

}

function cargarDatos(id){
    console.log('click editar' );
    let xhr = new XMLHttpRequest();    
    xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4 && xhr.status==200){   
           let vehiculo=JSON.parse(xhr.responseText);
                document.getElementById('id').value=vehiculo.id;
                document.getElementById('matricula').value=vehiculo.matricula;
                document.getElementById('modelo').value=vehiculo.modelo;
                document.getElementById('Km').value=vehiculo.km;
        }    
   };
   xhr.open('GET', 'http://localhost:8080/wsrest/api/vehiculo/'+id);
   xhr.send( );
}

function editar(){
    let id = document.getElementById('id').value;
    let matricula = document.getElementById('matricula').value;
    let modelo = document.getElementById('modelo').value;
    let km = document.getElementById('Km').value;
    let jsonCoche = {
        "id":id,
        "matricula" : matricula,
        "modelo": modelo,
        "km": km
    };

   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4){   
            if(xhr.status==200){
                showAlert("Vehiculo modificado","success"); 
            }else if(xhr.status==404){
                showAlert("Parametros incorrectos","danger"); 
            }else if(xhr.status==409){
                showAlert("esa matricula ya existe","danger"); 
            }else if(xhr.status==500){
                showAlert("exiten errores en los datos","danger"); 
            }
            refrescarLista();
        }    
   };
   xhr.open('PUT', 'http://localhost:8080/wsrest/api/vehiculo/'+id);
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );

}

function bajaorecuperar(id,opcion){
    if (opcion=="baja"){
        let jsonCoche = {
            "fechabaja":new Date()
        };
    }else{
        let jsonCoche = {
            "fechabaja":null
        };
    }
   let xhr = new XMLHttpRequest();    
   xhr.onreadystatechange = function(){ 
        if (xhr.readyState == 4){   
            if(xhr.status==200){
                showAlert("Vehiculo dado de baja","success"); 
            }else if(xhr.status==404){
                showAlert("Parametros incorrectos","danger"); 
            }else {
                showAlert("exiten errores en los datos","danger"); 
            }
            refrescarLista();
            refrescarListaBajas();
        }    
   };
   xhr.open('PATCH', 'http://localhost:8080/wsrest/api/vehiculo/'+id);
   xhr.setRequestHeader("Content-type", "application/json");
   xhr.send( JSON.stringify(jsonCoche) );
}


function showAlert( texto, tipo = 'info' ){

    
    let alertHTML = `<div class="alert alert-${tipo} alert-dismissible fade show" role="alert">
         <p>${texto}</p>
         <button type="button" class="close" data-dismiss="alert" aria-label="Close">
             <span aria-hidden="true">&times;</span>
         </button>
         </div>`;
 
     document.getElementById('alert').innerHTML = alertHTML;
 
 
 }// showAlert

