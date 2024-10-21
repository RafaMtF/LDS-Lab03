"use client";

import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";

export default function Page() {
  const [aluno, setAluno] = useState({
    nome: "",
    email: "",
    cpf: "",
    rg: "",
    endereco: "",
    moedas: 0,
    nomeInstituicao: "",
  });

  function onSubmit() {
    fetch("http://localhost:8081/aluno", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(aluno),
    });
    console.log(aluno);
  }

  useEffect(() => {
    console.log("Aluno", aluno);
  }, [aluno]);

  return (
    <div className="p-8">
      <h1 className="text-2xl font-semibold">Criar aluno:</h1>
      <form onSubmit={onSubmit}>
        <div className="flex flex-col space-y-4 mt-4">
          <input
            type="text"
            placeholder="Nome"
            value={aluno.nome}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setAluno({ ...aluno, nome: e.target.value })}
          />
          <input
            type="email"
            placeholder="Email"
            value={aluno.email}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setAluno({ ...aluno, email: e.target.value })}
          />
          <input
            type="text"
            placeholder="CPF"
            value={aluno.cpf}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setAluno({ ...aluno, cpf: e.target.value })}
          />
          <input
            type="text"
            placeholder="RG"
            value={aluno.rg}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setAluno({ ...aluno, rg: e.target.value })}
          />
          <input
            type="text"
            placeholder="Endereço"
            value={aluno.endereco}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) => setAluno({ ...aluno, endereco: e.target.value })}
          />
          <input
            type="text"
            placeholder="Nome da instituição"
            value={aluno.nomeInstituicao}
            className="p-2 border border-gray-300 rounded"
            onChange={(e) =>
              setAluno({ ...aluno, nomeInstituicao: e.target.value })
            }
          />
          <Button type="submit" className="bg-green-500">
            Criar aluno
          </Button>
        </div>
      </form>
    </div>
  );
}
