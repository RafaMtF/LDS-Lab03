"use client";

import {useState, useEffect} from 'react'
import {Button} from "@/components/ui/button";
import Link from "next/link";

export default function Page(props) {
    const [transacoes, setTransacoes] = useState([])

    const id = props.params.id;

    useEffect(() => {
        fetch(`http://localhost:8081/api/extrato/aluno/${id}`)
            .then(res => res.json())
            .then(data => setTransacoes(data))
            .catch(err => console.error(err))
    }, [])

    return (
        <div className={"p-8 m-auto w-[70vw] h-[100vh]"}>
            <div className={"flex justify-between"}>
                <h1 className={"text-2xl font-semibold"}>Extrato do aluno</h1>
            </div>
            <div className={"mt-3 p-4 grid grid-cols-3 gap-2"}>
                {transacoes.length > 0 ? transacoes.map((transacao) => (
                    <div key={transacao.id} className={"border-0 rounded-lg bg-slate-100 p-2"}>
                        <h1 className={"text-xl font-semibold"}>Professor: {transacao.professorId}</h1>
                        <p>Quantidade de moedas: {transacao.quantidadeMoedas}</p>
                        <p>Motivo: {transacao.motivo}</p>
                        <p>Data e hora: {transacao.dataHora}</p>
                    </div>
                )) : <>Você ainda não tem transações</>}
            </div>
        </div>
    )
}