/* eslint-disable react/prop-types */
import { useState } from "react"
import './TwitterFollowCard.css'
export function TwitterFollowCard({ userName, name,}) {

    const sessionName = sessionStorage.getItem('email')
    const [isFollowing, setIsFollowing] = useState(false)

    const estilosBoton = isFollowing ? 'isFollowing' : 'notFollowing'

    const manejadorClick = ()=>{

        setIsFollowing(!isFollowing)

    }

    return (
        <article>
            <header>
                <img src={`https://unavatar.io/${userName}`} />
                <div>
                    <strong>{name}</strong>
                    <span>{sessionName}</span>
                </div>
            </header> {/* Falta cerrar la etiqueta header */}
            <aside>
                <button className={estilosBoton} onClick={manejadorClick}>SEGUIR</button>
            </aside>
        </article>
    )
}

export default TwitterFollowCard