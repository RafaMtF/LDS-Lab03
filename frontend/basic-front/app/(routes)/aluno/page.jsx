"use client";

import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button";
import Link from "next/link";
import CardVantagem from "@/components/CardVantagem";

function Page() {
  const [aluno, setAluno] = useState([]);
  const [vantagens, setVantagens] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/vantagem/ativas")
      .then((res) => res.json())
      .then((data) => {
        setVantagens(data);
        console.log(data);
      })
      .catch((err) => console.error(err));
  }, []);

  useEffect(() => {
    fetch("http://localhost:8081/aluno/1")
      .then((res) => res.json())
      .then((data) => setAluno(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <>
      <div className={"p-8 h-full w-full"}>
        <div className={"flex justify-between"}>
          <div></div>
          <h1 className={"text-3xl font-bold"}>
            Confira as vantagens disponíveis!
          </h1>
          <div></div>
        </div>
        <div className={"mt-3 p-4 grid grid-cols-3 gap-2"}>
          {vantagens.length > 0 ? (
            vantagens.map((vantagem) => (
              <CardVantagem key={vantagem.id} vantagem={vantagem} aluno={aluno}/>
            ))
          ) : (
            <p>Nenhuma vantagem cadastrada</p>
          )}
        </div>
      </div>
      <button
        className="h-[60px] w-[200px] bg-[#EDF5FC] border-2 border-[#B8C5D6] rounded-md fixed bottom-5 right-5 md:bottom-10 md:left-10"
        onClick={() => window.location.replace("/")}
      >
        Sair da visualização de aluno
      </button>
    </>
  );
}

export default Page;
