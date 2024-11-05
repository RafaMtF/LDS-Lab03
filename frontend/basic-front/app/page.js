import { Button } from "@/components/ui/button";
import Link from "next/link";

export default function Home() {
  return (
    <div className="flex-col w-[100vw] h-[100vh]">
      <div className="shadow-md h-20 bg-yellow-600 grid grid-cols-8">
        <div className="col-span-1"></div>
        <h1 className="text-4xl font-semibold text-white content-center col-span-5">Bem vindo(a) ao sistema de moedas</h1>
        <div className="flex items-center justify-around col-span-1">
            <Button>
                <Link href="transacao/envio-moedas">Enviar moedas</Link>
            </Button>
        </div>
        <div className="col-span-1"></div>
      </div>
      <div className="m-auto flex p-4 justify-around w-[70vw]">
        <div></div>
        <Button>
          <Link href="aluno">Aluno</Link>
        </Button>

        <Button>
          <Link href="empresa-parceira">Empresa Parceira</Link>
        </Button>

        <Button>
          <Link href="professor">Professor</Link>
        </Button>

        <Button>
          <Link href="vantagens">Vantagens</Link>
        </Button>
        <div></div>
      </div>
    </div>
  );
}
