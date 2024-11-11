"use client";

import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button";
import Link from "next/link";

function Page() {
  const [alunos, setAlunos] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/aluno/1")
      .then((res) => res.json())
      .then((data) => setAlunos(data))
      .catch((err) => console.error(err));
  }, []);

  return (
    <div className={"p-8"}>
      <div className={"flex justify-between"}>
        <div></div>
        <h1 className={"text-2xl font-semibold"}>Seja Bem vindo(a)</h1>
        <div></div>
      </div>
      <div>
        <Button><Link href={"/aluno/vantagens"}>Confira as vantagens</Link></Button>
      </div>
    </div>
  );
}

export default Page;
