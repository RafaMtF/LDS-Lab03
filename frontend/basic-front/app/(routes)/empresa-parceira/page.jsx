"use client";

import {useState, useEffect} from 'react'
import {Button} from "@/components/ui/button";
import Link from "next/link";

function Page() {
    const [empresaParceira, setEmpresaParceira] = useState([])

    useEffect(() => {
        fetch('http://localhost:8081/empresa-parceira')
            .then(res => res.json())
            .then(data => setEmpresaParceira(data))
            .catch(err => console.error(err))
    }, [])

    return (
        <div className={"p-8 h-[100vh]"}>
            <div className={"flex justify-between"}>
                <h1 className={"text-2xl font-semibold"}>Empresas Parceiras</h1>
                <Button className={"bg-green-500"}>
                    <Link href="empresa-parceira/cadastro">Criar empresa parceira</Link>
                </Button>
            </div>
            <div className={"mt-3 p-4 grid grid-cols-3 gap-2"}>
                {empresaParceira.length > 0 ? empresaParceira.map((aluno) => (
                    <div key={aluno.id} className={"border-0 rounded-lg bg-slate-100 p-2"}>
                        <h1 className={"text-xl font-semibold"}>{empresaParceira.nome}</h1>
                        <Button className={"bg-yellow-400 text-black"}>
                            <Link href={`/empresa-parceira/${empresaParceira.id}`}>Editar</Link>
                        </Button>
                    </div>
                )) : <>Empresas não encontradas</>}
            </div>
        </div>
    )
}

export default Page;