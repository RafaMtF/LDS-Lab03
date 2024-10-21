"use client"

import {useState, useEffect} from 'react'
import {Button} from "@/components/ui/button";
import Link from "next/link";

function Page() {
    const [alunos, setAlunos] = useState([])

    useEffect(() => {
        fetch('http://localhost:8081/aluno')
            .then(res => res.json())
            .then(data => setAlunos(data))
            .catch(err => console.error(err))
    }, [])

    return (
        <div className={"p-8 h-[100vh]"}>
            <div className={"flex justify-between"}>
                <h1 className={"text-2xl font-semibold"}>Alunos</h1>
                <Button className={"bg-green-500"}>
                    <Link href="aluno/cadastro">Criar aluno</Link>
                </Button>
            </div>
            <div className={"mt-3 p-4 grid grid-cols-3 gap-2"}>
                {alunos.length > 0 ? alunos.map((aluno) => (
                    <div key={aluno.id} className={"border-0 rounded-lg bg-slate-100 p-2"}>
                        <h1 className={"text-xl font-semibold"}>{aluno.nome}</h1>
                        <p>{aluno.nomeInstituicao}</p>
                        <Button className={"bg-yellow-400 text-black"}>
                            <Link href={`/aluno/${aluno.id}`}>Editar</Link>
                        </Button>
                    </div>
                )) : <>Alunos não encontrados</>}
            </div>
        </div>
    )
}

export default Page