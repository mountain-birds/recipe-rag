import re
from PyPDF2 import PdfReader

def extract_text_from_pdf(pdf_path):
    reader = PdfReader(pdf_path)
    text = ""
    for page in reader.pages:
        text += page.extract_text() + "\n"
    return text

def chunk_recipe(text):
    chunks = []

    # Split by major headings
    sections = re.split(r"(## .+)", text)  # Markdown-style headings
    print(len(sections))
    current_section = None

    for part in sections:
        if part.startswith("##"):
            current_section = part.strip("# ").strip()
        else:
            if current_section and part.strip():
                # Further split instructions into steps
                if current_section.lower().startswith("instructions"):
                    steps = re.split(r"\n\d+\.", part)
                    for step in steps:
                        if step.strip():
                            chunks.append({
                                "section": current_section,
                                "content": step.strip()
                            })
                else:
                    chunks.append({
                        "section": current_section,
                        "content": part.strip()
                    })
    return chunks

if __name__ == "__main__":
    pdf_path = "HoneyButterMilkBuns.pdf"
    text = extract_text_from_pdf(pdf_path)
    recipe_chunks = chunk_recipe(text)

    # Example: print chunks
    for c in recipe_chunks[:5]:
        print(f"Section: {c['section']}")
        print(f"Content: {c['content'][:200]}...\n")