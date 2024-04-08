import React, {useState} from 'react'

export function Login (){

    async function userExist(name){

       exist = await fetch("https://localhost:5173/api/users/"+{name})

        return exist
    }



    return (

        <body>
        <div class="login-container">
            <h2>Iniciar Sesión</h2>
            <form action="#" method="post">
                <input id="inputName" type="text" name="nombre" placeholder="Nombre de usuario" required/>
                <input id="inputPassword" type="password" name="contraseña" placeholder="Contraseña" required/>
                <input id="inputSubmit" type="submit" onClick={()=>{

                            userExist(Doc)

                        return null;
                }}  value="Iniciar Sesión"/>
            </form>
        </div>
        </body>


    )
}