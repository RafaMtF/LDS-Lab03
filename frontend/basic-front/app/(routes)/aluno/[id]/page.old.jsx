"use client";

import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";

export default function Page(props) {
  const [aluno, setAluno] = useState({});
  const [instituicoes, setInstituicoes] = useState([]);

  const id = props.params.id;

  function onSubmit() {
    fetch(`http://localhost:8081/aluno/${id}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(aluno),
    });
  }

  useEffect(() => {
    fetch("http://localhost:8081/instituicaoEnsino")
      .then((res) => res.json())
      .then((data) => setInstituicoes(data))
      .catch((err) => console.error(err));
  }, []);

  useEffect(() => {
    fetch(`http://localhost:8081/aluno/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setAluno(data);
      });
  }, [id]);

  return (
    <div className="p-8">
      <h1 className="text-2xl font-semibold">Editar aluno:</h1>
      <form onSubmit={onSubmit}>
        <div className="flex flex-col space-y-4 mt-4">
          <label>
            Nome:
            <input
              type="text"
              placeholder="Nome"
              value={aluno.nome}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) => setAluno({ ...aluno, nome: e.target.value })}
            />
          </label>
          <label>
            Email:
            <input
              type="email"
              placeholder="Email"
              value={aluno.email}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) => setAluno({ ...aluno, email: e.target.value })}
            />
          </label>
          <label>
            CPF:
            <input
              type="text"
              placeholder="CPF"
              value={aluno.cpf}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) => setAluno({ ...aluno, cpf: e.target.value })}
            />
          </label>
          <label>
            RG:
            <input
              type="text"
              placeholder="RG"
              value={aluno.rg}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) => setAluno({ ...aluno, rg: e.target.value })}
            />
          </label>
          <label>
            Endereço:
            <input
              type="text"
              placeholder="Endereço"
              value={aluno.endereco}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) => setAluno({ ...aluno, endereco: e.target.value })}
            />
          </label>
          <label>
            Instituição cadastrada:
            <select
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) =>
                setAluno({ ...aluno, instituicaoEnsino: e.target.value })
              }
            >
              <option value="">Selecione uma instituicao de ensino</option>
              {instituicoes.map((instituicao) => (
                <option
                  key={instituicao.id}
                  value={instituicao.nome}
                  selected={
                    instituicao.nome === aluno.instituicaoEnsino
                      ? "selected"
                      : ""
                  }
                >
                  {instituicao.nome}
                </option>
              ))}
            </select>
            {/* <input
              type="text"
              placeholder="Nome da instituição"
              value={aluno.nomeInstituicao}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) =>
                setAluno({ ...aluno, nomeInstituicao: e.target.value })
              }
            /> */}
          </label>
          <label className="border-0 bg-gray-200 rounded p-2">
            Saldo:
            <input
              type="number"
              placeholder="Saldo"
              value={aluno.saldo}
              className="p-2 border border-gray-300 rounded w-full"
              disabled
              onChange={(e) => setAluno({ ...aluno, moedas: e.target.value })}
            />
          </label>
          <Button type="submit" className="bg-green-500">
            Atualizar aluno
          </Button>
        </div>
      </form>
    </div>
  );
}
