import { useEffect, useState } from "react";
import { obtenerPartes, type ParteTrabajo } from "./services/partesService";
import './App.css';

function App(){
  const [partes, setPartes] = useState<ParteTrabajo[]>([])
  const [cargando, setCargando] = useState(true)
  const [error, setError] = useState('')

  useEffect(() => {
    obtenerPartes().then(setPartes).catch(() => setError('No se pudieron cargar los partes')).finally(() => setCargando(false))
  }, [])

  const pendientes = partes.filter(
    (parte) => parte.estado === 'PENDIENTE'
  ).length

  return (
    <main className="contenedor">
      <header className="cabecera">
        <div>
          <h1>Partes de trabajo</h1>
          <p>Gestión de trabajos y firmas de clientes</p>
        </div>
      </header>

      <section className="resumen">
        <div className="tarjeta">
          <span>Total de partes</span>
          <strong>{partes.length}</strong>
        </div>

        <div className="tarjeta">
          <span>Pendientes de firma</span>
          <strong>{pendientes}</strong>
        </div>
      </section>

      <section className="listado">
        <h2>Partes registrados</h2>

        {cargando && <p>Cargando partes...</p>}
        {error && <p role="alert">{error}</p>}

         {!cargando && !error && partes.length === 0 && (
          <p>Todavía no hay partes registrados.</p>
        )}

                {partes.map((parte) => (
          <article className="parte" key={parte.id}>
            <div>
              <h3>{parte.cliente}</h3>
              <p>{parte.descripcion}</p>
              <small>{parte.fecha}</small>
            </div>

            <span className={`estado ${parte.estado.toLowerCase()}`}>
              {parte.estado}
            </span>
          </article>
        ))}
      </section>
    </main>
  )
}

export default App