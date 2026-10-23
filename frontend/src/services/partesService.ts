export type ParteTrabajo = {
    id:number
    cliente: string
    descripcion: string
    fecha: string
    estado: string
}

const API_URL = 'http://localhost:8080/api/partes'

export async function obtenerPartes(): Promise<ParteTrabajo[]> {
    const respuesta = await fetch(API_URL)

    if (!respuesta.ok){
        throw new Error('No se pudieron cargar los partes')
    }
    return respuesta.json() as Promise<ParteTrabajo[]>
}