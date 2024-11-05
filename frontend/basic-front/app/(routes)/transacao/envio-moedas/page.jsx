"use client";

import { Button } from "@/components/ui/button";
import { useEffect, useState } from "react";

export default function Page() {
  const [transacao, setTransacao] = useState({
    professorId: "",
    alunoId: "",
    quantidadeMoedas: "",
    motivo: "",
  });
  const [professores, setProfessores] = useState([]);
  const [alunos, setAlunos] = useState([]);

  function onSubmit() {
    fetch("http://localhost:8081/api/transacoes/enviar", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(transacao),
    });
    console.log(transacao);
    window.history.back();
  }

  useEffect(() => {
    fetch("http://localhost:8081/professor")
      .then((res) => res.json())
      .then((data) => setProfessores(data))
      .catch((err) => console.error(err));
  }, []);

  useEffect(() => {
    fetch("http://localhost:8081/aluno")
      .then((res) => res.json())
      .then((data) => setAlunos(data))
      .catch((err) => console.error(err));
  }, []);

  useEffect(() => {
    console.log("Transacao", transacao);
  }, [transacao]);

  return (
    <div className="p-8">
      <h1 className="text-2xl font-semibold">Enviar moedas:</h1>
      <form onSubmit={onSubmit}>
        <div className="flex flex-col space-y-4 mt-4">
          <label>
            Id do professor:
            <select
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) =>
                setTransacao({ ...transacao, professorId: e.target.value })
              }
            >
              <option value="">Selecione um professor</option>
              {professores.map((professor) => (
                <option key={professor.id} value={professor.id}>
                  {professor.nome}
                </option>
              ))}
            </select>
          </label>
          <label>
            Id do aluno:
            <select
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) =>
                setTransacao({ ...transacao, alunoId: e.target.value })
              }
            >
              <option value="">Selecione um aluno</option>
              {alunos.map((aluno) => (
                <option key={aluno.id} value={aluno.id}>
                  {aluno.nome}
                </option>
              ))}
            </select>
          </label>
          <label>
            Quantidade de moedas a ser enviada:
            <input
              type="number"
              placeholder="Quantidade de moedas a ser enviada"
              value={transacao.quantidadeMoedas}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) =>
                setTransacao({ ...transacao, quantidadeMoedas: e.target.value })
              }
            />
          </label>
          <label>
            Motivo da Transacao:
            <textarea
              placeholder="Motivo"
              value={transacao.motivo}
              className="p-2 border border-gray-300 rounded w-full"
              onChange={(e) =>
                setTransacao({ ...transacao, motivo: e.target.value })
              }
            />
          </label>
          <Button type="submit" className="bg-green-500">
            Enviar
          </Button>
        </div>
      </form>
    </div>
  );
}
