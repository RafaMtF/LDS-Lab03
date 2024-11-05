"use client";

import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button";
import Link from "next/link";

function Page() {
  const [professores, setProfessores] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/professor")
      .then((res) => res.json())
      .then((data) => setProfessores(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className={"p-8 h-[100vh]"}>
      <div className={"flex justify-between"}>
        <h1 className={"text-2xl font-semibold"}>Professores</h1>
        <Button className={"bg-green-500"}>
          <Link href="professor/cadastro">Criar professor</Link>
        </Button>
      </div>
      <div className={"mt-3 p-4 grid grid-cols-3 gap-2"}>
        {professores.length > 0 ? (
          professores.map((professor) => (
            <div
              key={professor.id}
              className={"border-0 rounded-lg bg-slate-100 p-2"}
            >
              <h1 className={"text-xl font-semibold"}>{professor.nome}</h1>
              <p>{professor.nomeInstituicao}</p>
              <p className="font-semibold">Saldo: {professor.saldo}</p>
              <div className={"flex justify-between"}>
                <Button className={"bg-green-400 text-black"}>
                  <Link href={`/professor/${professor.id}`}>Editar</Link>
                </Button>
                <Button className={"bg-yellow-500"}>
                  <Link href={`transacao/extrato/professor/${professor.id}`}>
                    Consultar extrato
                  </Link>
                </Button>
              </div>
            </div>
          ))
        ) : (
          <>Professores não encontrados</>
        )}
      </div>
    </div>
  );
}

export default Page;
